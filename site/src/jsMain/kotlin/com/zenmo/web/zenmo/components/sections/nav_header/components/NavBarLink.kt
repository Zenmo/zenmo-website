package com.zenmo.web.zenmo.components.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignContent
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.colors.shifted
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.LabelLargeTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

val NavBarLinkVariant = LinkStyle.addVariant(
    extraModifier = { TextStyle.toModifier(LabelLargeTextStyle) }
) {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .alignContent(AlignContent.Center)
            .color(SitePalette.light.onBackground)
            .background(colorPalette.overlay)
            .borderRadius(r = 30.px)
            .textDecorationLine(TextDecorationLine.None)
            .transition(
                Transition.of("0.2s"),
            )

    }
    hover {
        Modifier.background(colorPalette.overlay.shifted(colorMode, 0.1f))
    }
    active {
        Modifier.background(colorPalette.overlay.shifted(colorMode, 0.15f))
    }
    Breakpoint.LG {
        Modifier
            .size(width = 11.5.em, height = 3.8.em)
    }

    Breakpoint.MD {
        Modifier
            .size(width = 10.5.em, height = 3.2.em)
    }

    Breakpoint.XL {
        Modifier.size(width = 13.8.em, height = 3.9.em)
    }

}

val ActiveNavBarLinkVariant = CssStyle {
    base {
        Modifier
            .color(SitePalette.light.onPrimary)
            .background(SitePalette.light.primary)
            .transition(Transition.of("0.1s"))
    }
    hover {
        Modifier.background(SitePalette.light.primary)
    }

}

@Composable
fun NavBarLink(
    href: String,
    en: String,
    nl: String,
    modifier: Modifier = Modifier,
    isActive: Boolean,
) {
    val finalModifier = if (isActive) {
        ActiveNavBarLinkVariant.toModifier()
    } else {
        Modifier
    }.then(modifier)

    Link(
        path = href,
        variant = NavBarLinkVariant,
        modifier = finalModifier
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LangText(en = en, nl = nl)
        }
    }
}

@Composable
fun isPathActive(href: String): Boolean {
    val currentPage = rememberPageContext()
    return currentPage.route.path == href
}