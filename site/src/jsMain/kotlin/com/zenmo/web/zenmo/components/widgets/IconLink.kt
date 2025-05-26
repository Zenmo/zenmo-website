package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignContent
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.shifted
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.percent

@Composable
fun IconLink(
    modifier: Modifier = Modifier,
    href: String,
    content: @Composable () -> Unit,
) {
    Link(
        path = href,
        modifier = modifier,
        variant = IconLinkVariant,
        openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
    ) {
        content()
    }
}

val IconLinkVariant = LinkStyle.addVariant {
    base {
        Modifier
            .textDecorationLine(TextDecorationLine.None)
            .width(auto)
            .height(auto)
            .alignContent(AlignContent.Center)
            .justifyContent(JustifyContent.Center)
            .display(DisplayStyle.Flex)
            .padding(0.5.cssRem)
            .borderRadius(50.percent)
    }
    hover {
        Modifier.background(SitePalette.light.primary)
            .color(SitePalette.light.onPrimary)
    }
    active {
        Modifier.background(SitePalette.light.primary.shifted(colorMode, 0.2f))
    }
}
