package com.zenmo.server

import org.http4k.client.JavaHttpClient
import org.http4k.core.Credentials
import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.Uri
import org.http4k.core.then
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.security.OAuthProvider
import org.http4k.security.OAuthProviderConfig


fun OAuthHandler(
    baseUrl: String,
    clientId: String,
    clientSecret: String,
): RoutingHttpHandler {
    // the callback uri which is configured in our OAuth provider
    val callbackUri = Uri.of("$baseUrl/oauth/callback")

    // custom OAuth2 provider configuration
    val oauthProvider = OAuthProvider(
        OAuthProviderConfig(
            authBase = Uri.of("https://keycloak.zenmo.com/realms/zenmo/protocol/openid-connect"),
            authPath = "/auth",
            tokenPath = "/token",
            credentials = Credentials(clientId, clientSecret),
        ),
        JavaHttpClient(),
        callbackUri,
        listOf("profile", "email"),
        InMemorySessionOAuthPersistence(),
    )

    return routes(
        callbackUri.path bind Method.GET to oauthProvider.callback,
        "/login" bind Method.GET to oauthProvider.authFilter.then { Response(OK).body("logged in!") }
    )
}
