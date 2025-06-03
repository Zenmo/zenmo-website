package com.zenmo.server

import energy.lux.site.shared.AccessPolicy
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Source
import org.graalvm.polyglot.io.IOAccess
import org.http4k.core.ContentType
import org.http4k.core.Filter
import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.FORBIDDEN
import org.http4k.core.Status.Companion.NOT_FOUND
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.ResourceLoader
import org.http4k.routing.static
import java.net.URL

/**
 * Serve JS files or else pass to the next handler.
 */
class JsServerFilter(
    private val jsServer: JsServer = JsServer()
): Filter {
    override fun invoke(next: HttpHandler): HttpHandler = { request ->
        val path = request.uri.path
        if (path.endsWith(".mjs") || path.endsWith(".mjs.map")) {
            jsServer(request)
        } else {
            next(request)
        }
    }
}

/**
 * Check if the user is allowed to access the JavaScript file and serve it if so.
 * Does not check user roles yet.
 */
class JsServer(
    val resourceLoader: ResourceLoader = ResourceLoader.Companion.Directory("../site/build/rollup"),
): HttpHandler {
    override fun invoke(request: Request): Response {
        val path = request.uri.path
        val jsPath = path.removeSuffix(".map")
        val jsResourceUri = resourceLoader.load(jsPath)
        if (jsResourceUri == null) {
            return Response(NOT_FOUND)
        }
        val accessPolicy = getScriptAccessPolicy(jsResourceUri)
        if (accessPolicy !is AccessPolicy.Public) {
            return Response(FORBIDDEN)
        }

        val isSourceMap = path.endsWith(".map")
        return if (isSourceMap) {
            serveSourceMap(path)
        } else {
            serveJs(jsResourceUri)
        }
    }

    /**
     * Serve the source map after determining the access is allowed.
     */
    private fun serveSourceMap(path: String): Response {
        val resource = resourceLoader.load(path)
        if (resource == null) {
            return Response(NOT_FOUND)
        }

        return Response(OK)
            .header("Content-Type", "application/json")
            .body(resource.openStream())
    }

    /**
     * Serve the JavaScript after determining the access is allowed.
     */
    private fun serveJs(resource: URL): Response {
        return Response(OK)
            .header("Content-Type", "text/javascript")
            .body(resource.openStream())
    }
}

private fun getScriptAccessPolicy(resource: URL): AccessPolicy {
    val context = Context.newBuilder("js")
        .option("js.esm-eval-returns-exports", "true")
        .allowIO(IOAccess.ALL) // allow imports
        .build()

    val source = Source.newBuilder("js", resource).build()
    val output = context.eval(source)
    val jsAccessPolicy = output.getMember("accessPolicy")
    val jsonAccessPolicy = jsAccessPolicy.invokeMember("get").invokeMember("toJson")

    println("JSON accessPolicy of $resource: $jsonAccessPolicy")

    return AccessPolicy.fromJson(jsonAccessPolicy.asString())
}
