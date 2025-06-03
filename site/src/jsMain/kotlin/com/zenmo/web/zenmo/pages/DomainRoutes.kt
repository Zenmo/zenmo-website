package com.zenmo.web.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.AppGlobals
import com.varabyte.kobweb.core.Page
import com.zenmo.web.zenmo.components.widgets.UnknownDomain
import com.zenmo.web.zenmo.domains.lux.pages.LuxRoutingComponent
import com.zenmo.web.zenmo.domains.lux.subdomains.LuxSubdomainRoutingComponent
import com.zenmo.web.zenmo.domains.lux.subdomains.LuxSubdomains
import com.zenmo.web.zenmo.domains.zenmo.pages.ZenmoRoutingComponent
import kotlinx.browser.window

object SiteGlobals {
    val LUX_DOMAIN: String = AppGlobals.getValue("LUX_DOMAIN")
    val ZENMO_DOMAIN: String = AppGlobals.getValue("ZENMO_DOMAIN")
}

@Page("{...catch-all}")
@Composable
fun DomainRoutes() {
    val domain = window.location.host
    val luxSubdomainSuffix = ".${SiteGlobals.LUX_DOMAIN}"

    when {
        domain == SiteGlobals.LUX_DOMAIN -> LuxRoutingComponent()
        domain == SiteGlobals.ZENMO_DOMAIN -> ZenmoRoutingComponent()
        domain.endsWith(luxSubdomainSuffix) -> {
            val subdomain = domain.substringBefore(luxSubdomainSuffix)
            if (LuxSubdomains.entries.any { it.domainName == subdomain }) {
                LuxSubdomainRoutingComponent(
                    LuxSubdomains.entries.first { it.domainName == subdomain }
                )
            } else {
                UnknownDomain("LUX -> $subdomain")
            }
        }

        else -> UnknownDomain(domain)
    }
}


fun isLocalOrPreviewEnvironment(): Boolean {
    return listOf("preview", "local").any { envKeyword ->
        SiteGlobals.LUX_DOMAIN.contains(envKeyword) || SiteGlobals.ZENMO_DOMAIN.contains(envKeyword)
    }
}