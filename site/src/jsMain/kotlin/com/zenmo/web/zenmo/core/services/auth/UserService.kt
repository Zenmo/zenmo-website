package com.zenmo.web.zenmo.core.services.auth

import com.varabyte.kobweb.core.AppGlobals
import kotlinx.browser.window
import org.w3c.dom.url.URL

class UserService(
    private val backendUrl: String = AppGlobals.getValue("BACKEND_URL"),
) {
    fun loginUrl(): String {
        val url = URL(backendUrl)
        url.pathname = "/login"
        url.searchParams.set("redirect_to", window.location.href)
        return url.toString()
    }
}
