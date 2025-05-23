package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.DrechtstedenRouting
import com.zenmo.web.zenmo.domains.lux.subdomains.genius.GenuisRouting
import com.zenmo.web.zenmo.domains.lux.subdomains.hessenpoort.HessenpoortRouting


enum class LuxSubdomains(val subdomain: String) {
    DRECHTSTEDEN("drechtsteden"),
    GENIUS("genius"),
    HESSENPOORT("hessenpoort"),
}

@Composable
fun LuxSubdomainRoutingComponent(subdomain: String) {
    when (LuxSubdomains.valueOf(subdomain)) {
        LuxSubdomains.DRECHTSTEDEN -> DrechtstedenRouting()
        LuxSubdomains.GENIUS -> GenuisRouting()
        LuxSubdomains.HESSENPOORT -> HessenpoortRouting()
    }
}