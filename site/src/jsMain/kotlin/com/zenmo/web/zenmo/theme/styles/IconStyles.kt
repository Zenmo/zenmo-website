package com.zenmo.web.zenmo.theme.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.cssRem

val IconStyle = CssStyle {
    base {
        Modifier.size(1.55.cssRem)
    }
    /*todo add icon sizes for breakpoints*/
}

