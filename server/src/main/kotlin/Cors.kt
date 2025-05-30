package com.zenmo.server

import org.http4k.core.Filter
import org.http4k.core.Method
import org.http4k.filter.CorsPolicy
import org.http4k.filter.OriginPolicy
import org.http4k.filter.Pattern
import org.http4k.filter.ServerFilters
import java.lang.System.getenv

val corsPolicy = CorsPolicy(
    // value for development: .*(lux|zenmo)\.local:808[0-9]
    // value for production: https:\/\/((.*\.)?lux\.energy|zenmo\.com)
    // value for remote dev: https:\/\/((.*\.)?preview\.lux\.energy|preview\.zenmo\.com)
    OriginPolicy.Pattern(Regex(getenv("CORS_ORIGIN_PATTERN"))),
    listOf("content-type"),
    Method.entries,
    true
)

val corsFilter: Filter = ServerFilters.Cors(corsPolicy)
