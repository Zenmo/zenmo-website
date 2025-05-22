package com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowRightAlt
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.thenIf
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.IconStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun SideMenuNavLink(
    href: String,
    en: String,
    nl: String,
    isActive: Boolean,
    onClick: () -> Unit,
    hasBullet: Boolean = false,
) {
    Link(
        path = href,
        variant = SideMenuLinkVariant.thenIf(isActive, ActiveSideMenuLinkVariant),
        modifier = Modifier.onClick { onClick() }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.px),
        ) {
            when (hasBullet) {
                true -> Div { Text("•") }
                false ->
                    MdiArrowRightAlt(
                        modifier = IconStyle.toModifier()
                            .color(SitePalette.light.onBackground)
                            .thenIf(isActive, Modifier.color(SitePalette.light.primary))
                    )
            }
            LangText(en = en, nl = nl)
        }
    }
}