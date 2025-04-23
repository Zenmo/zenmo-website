package com.zenmo.web.zenmo.components.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Img

sealed interface SiteLogoKind : ComponentKind

val SiteLogoStyle = CssStyle<SiteLogoKind> {
    base {
        Modifier.display(DisplayStyle.Block)
    }
    Breakpoint.ZERO {
        Modifier.height(2.625.cssRem)
    }
    Breakpoint.SM {
        Modifier.height(2.75.cssRem)
    }
    Breakpoint.MD {
        Modifier.height(2.8.cssRem)
    }
    Breakpoint.LG {
        Modifier.height(4.cssRem)
    }
    Breakpoint.XL {
        Modifier.height(4.125.cssRem)
    }
}

/**
 * Making this a separate component so we can handle showing
 * Zenmo/LUX logo separately
 *
 * its zenmo logo for now
 * */
@Composable
fun SiteLogo() {
    Link("/") {
        Img(
            src = ("/logos/logo.png"),
            attrs = SiteLogoStyle.toModifier().toAttrs()
        )
    }
}