package com.zenmo.web.zenmo.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.theme.font.LabelLargeTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.font.TextStylePrimaryColor
import com.zenmo.web.zenmo.theme.toSitePalette
import com.zenmo.web.zenmo.utils.PublicRes
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

val FooterStyle = CssStyle.base {
    Modifier
        .backgroundColor(colorMode.toSitePalette().nearBackground)
        .padding(topBottom = 1.5.cssRem, leftRight = 10.percent)
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Row(
        FooterStyle.toModifier().then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Div(TextStyle.toModifier(LabelLargeTextStyle).toAttrs()) {
            Text(value = PublicRes.StringConstants.COPY_RIGHT)
        }
        
        Link(PublicRes.StringConstants.DISCLAIMER_URL) {
            LangText(
                en = "Disclaimer",
                nl = "Disclaimer",
                modifier = TextStyle.toModifier(LabelLargeTextStyle, TextStylePrimaryColor)
            )
        }
    }
}
