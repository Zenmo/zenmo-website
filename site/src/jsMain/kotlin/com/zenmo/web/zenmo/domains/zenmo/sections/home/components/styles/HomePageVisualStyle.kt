package com.zenmo.web.zenmo.domains.zenmo.sections.home.components.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px

val HomePageVisualStyle = CssStyle {
    Breakpoint.ZERO {
        Modifier.height(200.px)
    }
    Breakpoint.SM {
        Modifier.height(250.px)
    }
    Breakpoint.MD {
        Modifier.height(350.px)
    }
    Breakpoint.LG {
        Modifier.height(500.px)
    }
    Breakpoint.XL {
        Modifier.height(700.px)
    }
}