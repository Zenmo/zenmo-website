package com.zenmo.web.zenmo.core.services.auth

import com.varabyte.kobweb.core.AppGlobals
import kotlinx.browser.window
import web.http.RequestCredentials
import web.http.RequestInit
import web.http.fetch
import web.url.URL

class UserService(
    private val backendUrl: String = AppGlobals.getValue("BACKEND_URL"),
) {
    fun loginUrl(): String {
        val url = URL(backendUrl)
        url.pathname = "/login"
        url.searchParams.set("redirect_to", window.location.href)
        return url.toString()
    }

    suspend fun logout() {
        val url = URL(backendUrl)
        url.pathname = "/logout"
        val response = fetch(url, RequestInit(
            credentials = RequestCredentials.include,
        ))
        if (response.status != 200.toShort()) {
            throw Exception("Unhandled status code ${response.status}")
        }
    }

    suspend fun isLoggedIn(): Boolean {
        val url = URL(backendUrl)
        url.pathname = "/user-info"
        val response = fetch(url, RequestInit(
            credentials = RequestCredentials.include,
        ))
        return when (response.status) {
            200.toShort() -> true
            401.toShort() -> false
            else -> throw Exception("Unhandled status code ${response.status}")
        }
    }
}
