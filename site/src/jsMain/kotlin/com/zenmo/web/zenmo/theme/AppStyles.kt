package com.zenmo.web.zenmo.theme

import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.forms.ButtonVars
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariantBase
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.BreakpointSizes
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.zenmo.web.zenmo.utils.PublicRes
import org.jetbrains.compose.web.css.*

@InitSilk
fun initSiteStyles(ctx: InitSilkContext) {
    // This site does not need scrolling itself, but this is a good demonstration for how you might enable this in your
    // own site. Note that we only enable smooth scrolling unless the user has requested reduced motion, which is
    // considered a best practice.
    ctx.stylesheet.registerStyle("html") {
        cssRule(CSSMediaQuery.MediaFeature("prefers-reduced-motion", StylePropertyValue("no-preference"))) {
            Modifier.scrollBehavior(ScrollBehavior.Smooth)
        }
    }

    ctx.stylesheet.apply {
        registerStyleBase("body") {
            Modifier.fontFamily(
                PublicRes.FontFamilies.POPPINS_REGULAR,
                PublicRes.FontFamilies.POPPINS_MEDIUM,
                PublicRes.FontFamilies.MONTSERRAT_REGULAR,
                PublicRes.FontFamilies.MONTSERRAT_MEDIUM,
            )
        }
    }

    ctx.theme.apply {
        breakpoints = BreakpointSizes(
            sm = 30.cssRem, // 480 px,
            md = 48.cssRem, // 768 px
            lg = 81.25.cssRem, // 1300 px
            xl = 100.cssRem, // 1600 px
        )
    }
}

val HeadlineTextStyle = CssStyle.base {
    Modifier
        .fontSize(3.cssRem)
        .textAlign(TextAlign.Start)
        .lineHeight(1.2) //1.5x doesn't look as good on very large text
}

val SubheadlineTextStyle = CssStyle.base {
    Modifier
        .fontSize(1.cssRem)
        .textAlign(TextAlign.Start)
        .color(colorMode.toPalette().color.toRgb().copyf(alpha = 0.8f))
}

val CircleButtonVariant = ButtonStyle.addVariantBase {
    Modifier.padding(0.px).borderRadius(50.percent)
}

val RoundedButtonVariant = ButtonStyle.addVariantBase {
    Modifier.padding(0.px).borderRadius(1.cssRem)
}

val UncoloredButtonVariant = ButtonStyle.addVariantBase {
    Modifier.setVariable(ButtonVars.BackgroundDefaultColor, Colors.Transparent)
}
