package com.zenmo.web.zenmo.models.naviagtion

import com.zenmo.web.zenmo.core.data.StringRes
import com.zenmo.web.zenmo.core.data.asNavLinkPath

sealed class MenuItem {
    data class Simple(val path: String, val text: StringRes) : MenuItem()
    data class WithSubs(val text: StringRes, val subItems: List<Pair<String, StringRes>>) : MenuItem()

    companion object {
        val menuItems = listOf(
            Simple("/", StringRes.Home),
            WithSubs(
                StringRes.About,
                listOf(
                    Pair(StringRes.AboutZenmo.asNavLinkPath(), StringRes.AboutZenmo),
                    Pair(StringRes.AboutLux.asNavLinkPath(), StringRes.AboutLux),
                    Pair(StringRes.OurTeam.asNavLinkPath(), StringRes.OurTeam),
                    Pair(StringRes.History.asNavLinkPath(), StringRes.History),
                )
            ),
        )
    }
}