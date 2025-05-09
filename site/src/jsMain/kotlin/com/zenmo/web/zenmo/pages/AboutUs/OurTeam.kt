package com.zenmo.web.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.theme.font.DisplayTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Page
@Composable
fun OurTeamPage() {
    PageLayout("Customers") {
        Column(
            modifier = HeroContainerStyle.toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Div(TextStyle.toModifier(DisplayTextStyle).toAttrs()) {
                SpanText("Nice photos of the lovely people at Zenmo.")
            }

            val ctx = rememberPageContext()
            Button(
                onClick = {
                    ctx.router.tryRoutingTo("/")
                },
            ) {
                Text("Go back to the homepage")
            }
        }
    }
}