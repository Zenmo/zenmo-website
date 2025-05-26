package com.zenmo.server

import org.http4k.core.HttpHandler
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters
import org.http4k.server.Undertow
import org.http4k.server.asServer

fun main() {
    startServer()
}

fun startServer() {
    val config = Config()
    val routes = OAuthHandler(config.baseUrl, config.clientId, config.clientSecret)
    val app: HttpHandler = DebuggingFilters.PrintRequest()
        .then(corsFilter)
        .then(routes)

    val port = 9000
    val server = app.asServer(Undertow(port)).start()
    println("Listening on port $port")
}
