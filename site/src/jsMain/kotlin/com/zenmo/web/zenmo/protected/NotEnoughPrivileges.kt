package com.zenmo.web.zenmo.protected

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.PrimaryButton
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.P

@Composable
fun NotEnoughPrivileges() {
    Column(
        modifier = Modifier.fillMaxWidth().gap(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val ctx = rememberPageContext()
        HeaderText(
            enText = "Oops!",
            nlText = "Oeps!",
            modifier = Modifier
                .fontWeight(FontWeight.Bold)
                .margin(0.cssRem)
        )
        P(
            Modifier
                .color(SitePalette.light.onBackground.lightened(0.5f))
                .margin(0.cssRem)
                .toAttrs()
        ) {
            LangText(
                en = "You do not have enough privileges to access this page.",
                nl = "Je hebt niet genoeg rechten om deze pagina te bekijken."
            )
        }

        PrimaryButton(
            enText = "Return Home",
            nlText = "Terug naar Home",
            modifier = Modifier.margin(top = 1.cssRem)
        ) {
            ctx.router.navigateTo("/")
        }
    }
}