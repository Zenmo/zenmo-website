package com.zenmo.server

import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.FORBIDDEN
import org.http4k.core.Uri
import org.http4k.core.cookie.Cookie
import org.http4k.core.cookie.cookie
import org.http4k.core.cookie.invalidateCookie
import org.http4k.core.findSingle
import org.http4k.core.queries
import org.http4k.security.AccessToken
import org.http4k.security.CrossSiteRequestForgeryToken
import org.http4k.security.Nonce
import org.http4k.security.OAuthCallbackError
import org.http4k.security.OAuthPersistence
import org.http4k.security.PkceChallengeAndVerifier
import org.http4k.security.openid.IdToken
import java.time.Clock
import java.time.Duration

/**
 * Copied from https://github.com/http4k/http4k-by-example/blob/master/src/main/kotlin/verysecuresystems/oauth/InMemoryOAuthPersistence.kt
 *
 * This persistence handles both Bearer-token (API) and cookie-swapped access token (standard OAuth-web) flows.
 */
class InMemorySessionOAuthPersistence(
    private val clock: Clock = Clock.systemUTC(),
    private val tokenChecker: TokenChecker = TokenChecker,
) : OAuthPersistence {
    private val csrfName = "securityServerCsrf"
    private val originalUriName = "securityServerUri"
    private val clientAuthCookie = "securityServerAuth"
    private val sessionToAccessToken = mutableMapOf<String, AccessToken>()
    private val sessionToIdToken = mutableMapOf<String, IdToken>()

    override fun retrieveCsrf(request: Request) = request.cookie(csrfName)?.value?.let(::CrossSiteRequestForgeryToken)

    override fun retrieveNonce(request: Request): Nonce? = null

    override fun retrieveOriginalUri(request: Request): Uri? = request.cookie(originalUriName)?.value?.let(Uri::of)

    override fun retrievePkce(request: Request)  = null

    override fun retrieveToken(request: Request) = (tryBearerToken(request)
        ?: tryCookieToken(request))
        ?.takeIf(tokenChecker::check)

    fun retrieveIdToken(request: Request): IdToken? {
        val sessionId = request.cookie(clientAuthCookie)?.value
        return sessionToIdToken[sessionId]
    }

    fun clearSession(request: Request) {
        val sessionId = request.cookie(clientAuthCookie)?.value
        sessionToIdToken.remove(sessionId)
        sessionToAccessToken.remove(sessionId)
    }

    override fun assignCsrf(redirect: Response, csrf: CrossSiteRequestForgeryToken) = redirect.cookie(expiring(csrfName, csrf.value))

    override fun assignNonce(redirect: Response, nonce: Nonce): Response = redirect

    override fun assignOriginalUri(redirect: Response, originalUri: Uri): Response {
        val redirectUri = originalUri.queries().findSingle("redirect_to") ?: originalUri.toString()
        return redirect.cookie(expiring(originalUriName, redirectUri))
    }

    override fun assignPkce(redirect: Response, pkce: PkceChallengeAndVerifier) = redirect

    override fun assignToken(request: Request, redirect: Response, accessToken: AccessToken, idToken: IdToken?): Response {
        val sessionId = generateSessionId()
        sessionToAccessToken[sessionId] = accessToken
        if (idToken == null) {
            throw RuntimeException("Got no ID token from Keycloak")
        }
        sessionToIdToken[sessionId] = idToken

        return redirect
            .cookie(expiring(clientAuthCookie, sessionId))
            // removing cookies doesn't seem to work
            .invalidateCookie(csrfName)
            .invalidateCookie(originalUriName)
    }

    override fun authFailureResponse(reason: OAuthCallbackError) = Response(FORBIDDEN)
        .invalidateCookie(csrfName)
        .invalidateCookie(originalUriName)
        .invalidateCookie(clientAuthCookie)

    private fun tryCookieToken(request: Request) =
        request.cookie(clientAuthCookie)?.value?.let { sessionToAccessToken[it] }

    private fun tryBearerToken(request: Request) = request.header("Authorization")
        ?.removePrefix("Bearer ")
        ?.let { AccessToken(it) }

    private fun expiring(name: String, value: String) = Cookie(name, value,
        path = "/",
        expires = clock.instant().plus(Duration.ofDays(1)))
}

fun generateSessionId(): String {
    val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

    return buildString {
        repeat(23) { // LOG_2(23^62) = 131 bits of entropy
            append(alphabet.random())
        }
    }
}

object TokenChecker {
    fun check(accessToken: AccessToken): Boolean {
        // TODO check the actual expiry
        return (accessToken.expiresIn ?: 0) > 0
    }
}
