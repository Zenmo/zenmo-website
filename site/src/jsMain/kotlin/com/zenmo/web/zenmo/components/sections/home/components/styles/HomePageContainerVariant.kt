package com.zenmo.web.zenmo.components.sections.home.components.styles

import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.functions.RadialGradient
import com.varabyte.kobweb.compose.css.functions.radialGradient
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.components.widgets.SectionContainerStyle
import com.zenmo.web.zenmo.theme.toSitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.vh

val HomePageContainerVariant = SectionContainerStyle.addVariant {
    val colorPalette = colorMode.toSitePalette()
    base {
        Modifier
            .margin(topBottom = 5.cssRem)
    }
    Breakpoint.ZERO {
        Modifier
            .height(75.vh)
            .minHeight(38.cssRem)
    }
    Breakpoint.SM {
        Modifier
            .minHeight(40.6.cssRem)
    }
    Breakpoint.MD {
        Modifier
            .height(78.vh)
    }
    Breakpoint.LG {
        Modifier
            .height(75.vh)
    }
    Breakpoint.XL {
        Modifier
            .backgroundImage(
                radialGradient(
                    RadialGradient.Shape.Circle,
                    CSSPosition(x = 73.5.percent, y = 50.percent)
                ) {
                    add(colorPalette.primary.toRgb().copyf(alpha = 0.095f))
                    add(Colors.Transparent, 28.percent)
                }
            )
    }
}