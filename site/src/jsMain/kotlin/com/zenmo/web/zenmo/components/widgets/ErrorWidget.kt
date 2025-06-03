package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.icons.mdi.MdiError
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.PrimaryButton
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ErrorWidget(
    errorMessage: String,
    routeTo: String = "/"
) {
    val ctx = rememberPageContext()
    Column(
        modifier = Modifier.fillMaxWidth().gap(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MdiError(
            Modifier.color(Color.red)
                .fontSize(50.px)
        )
        SubHeaderText(
            enText = "Error",
            nlText = "Fout",
            modifier = Modifier.margin(0.cssRem)
        )
        P(
            Modifier
                .color(SitePalette.light.onBackground.lightened(0.5f))
                .fillMaxWidth()
                .textAlign(TextAlign.Center)
                .margin(top = 0.cssRem, bottom = 0.cssRem, leftRight = 5.cssRem)
                .toAttrs()
        ) {
            Text(errorMessage)
        }

        PrimaryButton(
            enText = "Return",
            nlText = "Terug",
            modifier = Modifier.margin(top = 1.cssRem)
        ) {
            ctx.router.navigateTo(routeTo)
        }
    }
}