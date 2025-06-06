package com.zenmo.web.zenmo.domains.lux.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.zenmo.web.zenmo.components.widgets.CardLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.user.UserMenuWidget
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.H1

@Composable
fun LuxHomePage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H1 {
            LangText(
                en = "LUX is Coming😎",
                nl = "LUX komt eraan😎"
            )
        }
        Link("/about") {
            LangText(
                en = "About Lux",
                nl = "Over lux",
            )
        }
        val LUX_DOMAIN = SiteGlobals.LUX_DOMAIN
        // We should be able to use "//" to match the current protocol.
        // Kobweb doesn't understand this unfortunately.
        // TODO: fix in kobweb
        val protocol = window.location.protocol
        SimpleGrid(
            numColumns(base = 1, md = 3, lg = 3, xl = 3),
            modifier = Modifier.gap(1.cssRem),
        ) {
            CardLink(
                url = "${protocol}://drechtsteden.$LUX_DOMAIN",
                imageUrl = "/img/drechtsteden-rivier.jpg",
                imageAltText = "Drechtsteden luchtfoto met rivier",
                nlTitle = "Drechtsteden",
                enTitle = "Drechtsteden"
            )
            CardLink(
                url = "${protocol}://genius.$LUX_DOMAIN",
                imageUrl = "/img/tue-luchtfoto.png",
                imageAltText = "TU/e Luchtfoto",
                nlTitle = "Genius",
                enTitle = "Genius"
            )
        }
        UserMenuWidget()
    }
}
