package com.zenmo.web.zenmo.components.sections.nav_header

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.HamburgerIcon
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.zenmo.web.zenmo.components.sections.nav_header.components.NavBar
import com.zenmo.web.zenmo.components.sections.nav_header.components.SideMenu
import com.zenmo.web.zenmo.components.sections.nav_header.components.SideMenuState
import com.zenmo.web.zenmo.components.sections.nav_header.components.SiteLogo
import com.zenmo.web.zenmo.components.widgets.button.IconButton
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.IconStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Header

sealed interface NavHeaderKind : ComponentKind

val NavHeaderStyle = CssStyle<NavHeaderKind>(extraModifier = {
    SmoothColorStyle.toModifier()
}) {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .fillMaxWidth()
            .backgroundColor(colorPalette.background.toRgb().copyf(alpha = 0.8f))
            .position(Position.Sticky)
            .top(0.percent)
            .backdropFilter(saturate(180.percent), blur(5.px))
            .boxShadow(spreadRadius = 2.px, color = colorPalette.overlay)
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.SpaceBetween)
            .alignItems(AlignItems.Center)
            .padding(leftRight = 50.px, topBottom = 10.px)
            .zIndex(1)
    }
    /*todo add padding modifiers for breakpoints*/
}


@Composable
private fun HamburgerButton(onClick: () -> Unit) {
    IconButton(
        onClick = onClick
    ) {
        HamburgerIcon(
            modifier = IconStyle.toModifier()
                .color(SitePalette.light.onPrimary)
        )
    }
}


@Composable
fun NavHeader() {
    Header(
        attrs = NavHeaderStyle.toModifier().toAttrs()
    ) {
        SiteLogo()

        Row(
            modifier = Modifier
                .displayIfAtLeast(Breakpoint.MD),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            NavBar()
        }


        Row(
            Modifier
                .displayUntil(Breakpoint.MD),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var menuState by remember { mutableStateOf(SideMenuState.CLOSED) }

            HamburgerButton(onClick = { menuState = SideMenuState.OPEN })

            if (menuState != SideMenuState.CLOSED) {
                SideMenu(
                    menuState,
                    close = { menuState = menuState.close() },
                    onAnimationEnd = { if (menuState == SideMenuState.CLOSING) menuState = SideMenuState.CLOSED }
                )
            }
        }
    }
}
