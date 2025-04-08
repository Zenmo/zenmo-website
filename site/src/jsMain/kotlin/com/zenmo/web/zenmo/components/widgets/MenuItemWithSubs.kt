package com.zenmo.web.zenmo.components.widgets

import DropdownContainerStyle
import DropdownItemStyle
import MenuItemParentStyle
import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.core.data.StringRes
import com.zenmo.web.zenmo.core.services.localization.stringResource
import com.zenmo.web.zenmo.styles.NavLinkStyles
import org.jetbrains.compose.web.css.cssRem

@Composable
fun MenuItemWithSubs(text: StringRes, subItems: List<Pair<String, StringRes>>) {
    Box(
        modifier = MenuItemParentStyle.toModifier()
            .then(NavLinkStyles.toModifier())
    ) {
        NavLink("", text)

        Column(
            modifier = DropdownContainerStyle.toModifier()
                .minWidth(10.cssRem)
        ) {
            subItems.forEach { (path, subText) ->
                Link(
                    path,
                    stringResource(subText),
                    modifier = DropdownItemStyle.toModifier(),
                    variant = UndecoratedLinkVariant.then(UncoloredLinkVariant)
                )
            }
        }
    }
}