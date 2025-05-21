package com.zenmo.server

import org.http4k.core.HttpHandler
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters
import org.http4k.server.Undertow
import org.http4k.server.asServer

fun main() {
    startServer()
}

fun startServer() {
    val app: HttpHandler = DebuggingFilters.PrintRequest()
        .then { Response(OK).body("Hello world") }

    val server = app.asServer(Undertow(9000)).start()
}
