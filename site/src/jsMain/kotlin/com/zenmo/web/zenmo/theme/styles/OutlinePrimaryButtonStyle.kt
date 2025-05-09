package com.zenmo.web.zenmo.theme.styles

import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.font.LabelLargeTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.toSitePalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px

val OutlinePrimaryButtonStyle = CssStyle(extraModifier = {
    TextStyle.toModifier(LabelLargeTextStyle).fontWeight(FontWeight.SemiBold)
}) {
    val colorPalette = colorMode.toSitePalette()
    base {
        Modifier
            .background(Colors.Transparent)
            .color(colorPalette.primary)
            .border(1.5.px, color = colorPalette.primary, style = LineStyle.Solid)
    }
    hover {
        Modifier
            .background(colorPalette.primary)
            .color(colorPalette.onPrimary)
    }
}