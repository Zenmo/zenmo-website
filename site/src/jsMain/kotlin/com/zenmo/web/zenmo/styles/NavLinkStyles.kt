package com.zenmo.web.zenmo.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.zenmo.web.zenmo.SitePalettes


val NavLinkStyles = CssStyle {
    hover {
        Modifier
            .color(SitePalettes.light.brand.primary)
    }
}