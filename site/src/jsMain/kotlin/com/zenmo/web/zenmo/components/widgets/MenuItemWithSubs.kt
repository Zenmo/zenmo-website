package com.zenmo.web.zenmo.components.widgets

import DropdownContainerStyle
import MenuItemParentStyle
import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.sections.nav_header.components.NavBarLink
import com.zenmo.web.zenmo.components.sections.nav_header.components.isPathActive
import com.zenmo.web.zenmo.models.navigation.MenuLanguage
import com.zenmo.web.zenmo.models.navigation.asNavLinkPath

@Composable
fun MenuItemWithSubs(titleText: MenuLanguage, subItems: List<MenuLanguage>) {
    val isMenuActive = subItems.any { isPathActive(href = it.en.asNavLinkPath(titleText.en)) }
    Box(
        modifier = MenuItemParentStyle.toModifier()
    ) {
        NavBarLink(
            href = subItems.firstOrNull()?.en?.asNavLinkPath(titleText.en) ?: "/",
            en = titleText.en,
            nl = titleText.nl,
            isActive = isMenuActive
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