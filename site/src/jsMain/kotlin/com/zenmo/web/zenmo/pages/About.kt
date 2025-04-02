package com.zenmo.web.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorPalettes
import com.zenmo.web.zenmo.HeadlineTextStyle
import com.zenmo.web.zenmo.components.layouts.PageLayout
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Page
@Composable
fun AboutPage() {
    PageLayout("About") {
        Column(
            modifier = HeroContainerStyle.toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Div(HeadlineTextStyle.toAttrs()) {
                SpanText("Coming soon")
            }

            val ctx = rememberPageContext()
            Button(
                onClick = {
                    ctx.router.tryRoutingTo("/")
                },
                colorPalette = ColorPalettes.Blue,
            ) {
                Text("Go back to the homepage")
            }
        }
    }
}