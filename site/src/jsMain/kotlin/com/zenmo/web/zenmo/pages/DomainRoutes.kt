package com.zenmo.web.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.AppGlobals
import com.varabyte.kobweb.core.Page
import com.zenmo.web.zenmo.components.widgets.UnknownDomain
import com.zenmo.web.zenmo.domains.lux.pages.LuxRoutingComponent
import com.zenmo.web.zenmo.domains.zenmo.pages.ZenmoRoutingComponent
import kotlinx.browser.window

object SiteGlobals {
    val LUX_DOMAIN: String = AppGlobals.getValue("LUX_DOMAIN")
    val ZENMO_DOMAIN: String = AppGlobals.getValue("ZENMO_DOMAIN")
}

@Page("{...catch-all}")
@Composable
fun DomainRoutes() {
    when (val domain = window.location.host) {
        SiteGlobals.LUX_DOMAIN -> LuxRoutingComponent()
        SiteGlobals.ZENMO_DOMAIN -> ZenmoRoutingComponent()
        else -> UnknownDomain(domain)
    }
}
