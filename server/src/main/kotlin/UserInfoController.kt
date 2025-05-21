package com.zenmo.server

import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.Status.Companion.UNAUTHORIZED
import org.http4k.format.KotlinxSerialization.json
import org.http4k.security.AccessToken
import org.http4k.security.openid.IdToken

/**
 * Returns user info from the session
 */
class UserInfoController(
    private val idTokenProvider: (Request) -> IdToken?,
) {
    fun handler(req: Request): Response {
        val idTokenString = idTokenProvider(req)
        if (idTokenString == null) {
            return Response(UNAUTHORIZED).body("Not logged in")
        }
        val idTokenPayload = decodeIdToken(idTokenString)
        return Response(OK).json(idTokenPayload)
    }
}

