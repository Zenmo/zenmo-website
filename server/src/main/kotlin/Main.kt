package com.zenmo.server

import org.http4k.core.ContentType
import org.http4k.core.Filter
import org.http4k.core.HttpHandler
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters
import org.http4k.routing.ResourceLoader
import org.http4k.routing.static
import org.http4k.server.Undertow
import org.http4k.server.asServer

fun main() {
    startServer()
}

fun startServer() {
    val config = Config()
    val routes = OAuthHandler(config.baseUrl, config.clientId, config.clientSecret)
    
    val app: HttpHandler = DebuggingFilters.PrintRequestAndResponse()
        .then(corsFilter)
        .then(jsFilter)
        .then(routes)

    val port = 9000
    val server = app.asServer(Undertow(port)).start()
    println("Listening on port $port")
}

val jsFilter: Filter = Filter { next -> { req ->
        val path = req.uri.path
        if (path.endsWith(".mjs") || path.endsWith(".mjs.map")) {
            jsStatic(req)
        } else {
            next(req)
        }
    }
}

val jsStatic: HttpHandler = static(
    ResourceLoader.Directory("../site/build/rollup"),
    "mjs" to ContentType("text/javascript"),
    "map" to ContentType("application/json"),
)
