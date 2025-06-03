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

    val oAuthSessions = InMemorySessionOAuthPersistence()
    val routes = OAuthHandler(
        baseUrl = config.baseUrl,
        clientId = config.clientId,
        clientSecret = config.clientSecret,
        oAuthSessions,
    )
    
    val app: HttpHandler = DebuggingFilters.PrintRequestAndResponse()
        .then(corsFilter)
        .then(JsServerFilter(
            JsServer(
                clientId =  config.clientId,
                oAuthSessions = oAuthSessions,
            )
        ))
        .then(routes)

    val port = 9000
    val server = app.asServer(Undertow(port)).start()
    println("Listening on port $port")
}

