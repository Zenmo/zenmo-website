package com.zenmo.server

import java.lang.System.getenv

data class Config(
    val port: Int = getenv("PORT")?.toInt() ?: 9000,
    val baseUrl: String = getenv("BASE_URL") ?: "http://localhost:$port",
    val clientId: String = getenv("CLIENT_ID"),
    val clientSecret: String = getenv("CLIENT_SECRET"),
)
