package com.zenmo.web.zenmo.components.sections.nav_header.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowRightAlt
import com.varabyte.kobweb.silk.components.icons.mdi.MdiExpandMore
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.models.navigation.MenuLanguage
import com.zenmo.web.zenmo.models.navigation.asNavLinkPath
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.IconStyle
import org.jetbrains.compose.web.css.*


val AnimatedIconStyle = CssStyle {
    base {
        Modifier
            .transition(
                Transition.of(
                    property = "transform",
                    duration = 300.ms,
                    timingFunction = AnimationTimingFunction.Ease
                )
            )
    }
}

val AnimatedDropdownStyle = CssStyle {
    base {
        Modifier
            .transition(
                Transition.of(
                    property = "height",
                    duration = 300.ms,
                    timingFunction = AnimationTimingFunction.Ease
                )
            )
    }
}


@Composable
fun ExpandableSideMenuItem(
    title: MenuLanguage,
    subItems: List<MenuLanguage>,
    isAnySubItemActive: Boolean,
    onClick: () -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .gap(1.5.cssRem)
            .then(AnimatedDropdownStyle.toModifier()),
        horizontalAlignment = Alignment.End
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = ExpandableSideMenuItemStyle.toModifier()
                .thenIf(isExpanded, ActiveExpandableSideMenuItemStyle.toModifier())
                .onClick {
                    isExpanded = !isExpanded
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.px),
                modifier = Modifier.fillMaxWidth()
            ) {
                MdiArrowRightAlt(
                    modifier = IconStyle.toModifier()
                        .color(SitePalette.light.onBackground)
                        .thenIf(isAnySubItemActive, Modifier.color(SitePalette.light.primary))
                        .then(AnimatedIconStyle.toModifier())
                        .transform {
                            rotate(if (isExpanded) 90.deg else 0.deg)
                        }
                )
                LangText(en = title.en, nl = title.nl)
            }

            MdiExpandMore(
                modifier = IconStyle.toModifier()
                    .then(ExpandableSideMenuItemStyle.toModifier())
                    .then(AnimatedIconStyle.toModifier())
                    .transform {
                        rotate(if (isExpanded) 180.deg else 0.deg)
                    }
            )
        }
        if (isExpanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(left = 1.cssRem)
                    .gap(1.5.cssRem)
            ) {
                subItems.forEach { subItem ->
                    SideMenuNavLink(
                        href = subItem.en.asNavLinkPath(title.en),
                        en = subItem.en,
                        nl = subItem.nl,
                        isActive = isPathActive(href = subItem.en.asNavLinkPath(title.en)),
                        onClick = onClick,
                        hasBullet = true
                    )
                }
            }
        }
    }
}