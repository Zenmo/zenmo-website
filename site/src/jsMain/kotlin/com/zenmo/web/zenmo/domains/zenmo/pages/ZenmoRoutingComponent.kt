package com.zenmo.web.zenmo.domains.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.navigation.*
import com.varabyte.kobweb.silk.defer.DeferringHost
import com.zenmo.web.zenmo.components.widgets.CatchAllPage
import com.zenmo.web.zenmo.domains.zenmo.pages.aboutUs.OurTeamPage
import com.zenmo.web.zenmo.domains.zenmo.widgets.ComponentDemoPage
import kotlinx.browser.window

@Composable
fun ZenmoRoutingComponent() {
    val router = Router()
    com.varabyte.kobweb.core.init.initKobweb(router) { ctx ->
        ctx.router.register("/") { HomePage() }
        ctx.router.register("/contact") { ContactPage() }
        ctx.router.register("/customers") { CustomersPage() }
        ctx.router.register("/about-us/our-team") { OurTeamPage() }
        ctx.router.register("/what-we-do") { WhatPage() }
        if (window.location.host != "zenmo.com") {
            ctx.router.register("/component-demo") { ComponentDemoPage() }
        }
        ctx.router.register("/{...catch-all}") { CatchAllPage() }
    }

    router.tryRoutingTo(
        BasePath.remove(window.location.href.removePrefix(window.origin)),
        UpdateHistoryMode.REPLACE
    )

    router.renderActivePage { DeferringHost { it() } }
}

fun Router.register(nl: String, en: String, page: PageMethod) {
    register(nl, page)
    register(en, page)
}
