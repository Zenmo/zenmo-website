package com.zenmo.web.zenmo.domains.lux.subdomains.hessenpoort

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.Router
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.remove
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.domains.lux.subdomains.LuxSubdomains
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.SubdomainContent
import kotlinx.browser.window

@Composable
fun HessenpoortRouting() {
    val router = Router()
    com.varabyte.kobweb.core.init.initKobweb(router) { ctx ->
        ctx.router.register("/") { SubdomainContent(LuxSubdomains.HESSENPOORT.subdomain) }
    }
    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )
    router.renderActivePage { DeferringHost { it() } }
}