package com.zenmo.web.zenmo.components.sections.nav_header.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.components.overlay.Overlay
import com.varabyte.kobweb.silk.components.overlay.OverlayVars
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.thenIf
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.colors.shifted
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.button.IconButton
import com.zenmo.web.zenmo.models.navigation.MenuItem
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.IconStyle
import org.jetbrains.compose.web.css.*


val SideMenuStyle = CssStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .fillMaxHeight()
            .width(clamp(8.cssRem, 33.percent, 10.cssRem))
            .padding(top = 1.cssRem, leftRight = 1.cssRem)
            .gap(1.5.cssRem)
            .backgroundColor(colorPalette.overlay)
            .borderRadius(topLeft = 30.px, bottomLeft = 30.px)
    }
    Breakpoint.ZERO {
        Modifier.width(50.percent)
    }
    Breakpoint.SM {
        Modifier.width(43.percent)
    }
    Breakpoint.MD {
        Modifier.width(30.percent)
    }
}

val SideMenuSlideInAnim = Keyframes {
    from {
        Modifier.translateX(100.percent)
    }

    to {
        Modifier
    }
}

enum class SideMenuState {
    CLOSED,
    OPEN,
    CLOSING;

    fun close() = when (this) {
        CLOSED -> CLOSED
        OPEN -> CLOSING
        CLOSING -> CLOSING
    }
}

@Composable
fun SideMenu(
    menuState: SideMenuState,
    close: () -> Unit,
    onAnimationEnd: () -> Unit,
) {
    Overlay(
        modifier = Modifier
            .zIndex(2)
            .setVariable(OverlayVars.BackgroundColor, Colors.Transparent)
            .onClick { close() },
    ) {
        key(menuState) {
            Column(
                SideMenuStyle.toModifier()
                    .align(Alignment.CenterEnd)
                    .animation(
                        SideMenuSlideInAnim.toAnimation(
                            duration = 200.ms,
                            timingFunction = if (menuState == SideMenuState.OPEN) AnimationTimingFunction.EaseOut else AnimationTimingFunction.EaseIn,
                            direction = if (menuState == SideMenuState.OPEN) AnimationDirection.Normal else AnimationDirection.Reverse,
                            fillMode = AnimationFillMode.Forwards
                        )
                    )
                    .onAnimationEnd { onAnimationEnd() }
                    .onClick { it.stopPropagation() },
                horizontalAlignment = Alignment.End
            ) {
                IconButton(onClick = { close() }) {
                    CloseIcon(modifier = IconStyle.toModifier())
                }
                Column(
                    modifier = Modifier.gap(1.5.cssRem),
                    horizontalAlignment = Alignment.End
                ) {
                    MenuItem.menuItems.forEach { item ->
                        when (item) {
                            is MenuItem.Simple -> {
                                SideMenuNavLink(
                                    href = item.getPath,
                                    en = item.title.en,
                                    nl = item.title.nl,
                                    isActive = isPathActive(href = item.getPath),
                                    onClick = { close() }
                                )
                            }

                            is MenuItem.WithSubs -> {
                                /*todo in subsequent PR*/
                            }
                        }
                    }
                }
            }
        }
    }
}


val SideMenuLinkVariant = LinkStyle.addVariant {
    base {
        Modifier
            .textDecorationLine(TextDecorationLine.None)
            .color(SitePalette.light.onBackground)
    }
    hover {
        Modifier.color(SitePalette.light.primary)
    }
    active {
        Modifier.color(SitePalette.light.primary.shifted(colorMode, 0.15f))
    }
}

val ActiveSideMenuLinkVariant = LinkStyle.addVariant {
    base {
        Modifier.color(SitePalette.light.primary)
    }
}


@Composable
private fun SideMenuNavLink(
    href: String,
    en: String,
    nl: String,
    isActive: Boolean,
    onClick: () -> Unit,
) {
    Link(
        path = href,
        variant = SideMenuLinkVariant.thenIf(isActive, ActiveSideMenuLinkVariant),
        modifier = Modifier.onClick { onClick() }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LangText(en = en, nl = nl)
        }
    }
}