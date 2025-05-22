package com.zenmo.web.zenmo.domains.zenmo.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLanguage
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.core.services.localization.Language
import com.zenmo.web.zenmo.core.services.localization.LanguageManager
import com.zenmo.web.zenmo.core.services.localization.LocalLanguage
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.IconButton
import com.zenmo.web.zenmo.theme.font.BodyLargeTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.font.TextStyleBrandColor
import org.jetbrains.compose.web.css.cssRem


@Composable
fun LanguageSwitchButton() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(0.17.cssRem),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = LanguageManager::toggleLanguage) {
            MdiLanguage()
        }
        SpanText(
            text = when (LocalLanguage.current) {
                Language.English -> "EN"
                Language.Dutch -> "NL"
            },
            modifier = TextStyle.toModifier(
                BodyLargeTextStyle,
                TextStyleBrandColor
            )
        )
    }
}