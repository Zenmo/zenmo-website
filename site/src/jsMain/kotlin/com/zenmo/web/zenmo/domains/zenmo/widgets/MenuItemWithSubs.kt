package com.zenmo.web.zenmo.domains.zenmo.widgets

import DropdownContainerStyle
import MenuItemParentStyle
import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.domains.zenmo.navigation.MenuLanguage
import com.zenmo.web.zenmo.domains.zenmo.navigation.asNavLinkPath
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.NavBarLink
import com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components.isPathActive


val MainMenuItemHoverStyle = CssStyle {
    hover {
        Modifier.cursor(cursor = Cursor.Auto)
    }
}

@Composable
fun MenuItemWithSubs(titleText: MenuLanguage, subItems: List<MenuLanguage>) {
    val isMenuActive = subItems.any { isPathActive(href = it.en.asNavLinkPath(titleText.en)) }
    Box(
        modifier = MenuItemParentStyle.toModifier()
    ) {
        NavBarLink(
            href = "/",
            en = titleText.en,
            nl = titleText.nl,
            isActive = isMenuActive,
            modifier = MainMenuItemHoverStyle.toModifier()
        )

        Column(
            modifier = DropdownContainerStyle.toModifier()
        ) {
            subItems.forEach { menu ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    NavBarLink(
                        href = menu.en.asNavLinkPath(titleText.en),
                        en = menu.en,
                        nl = menu.nl,
                        isActive = isPathActive(href = menu.en.asNavLinkPath(titleText.en)),
                    )
                }
            }
        }
    }
}