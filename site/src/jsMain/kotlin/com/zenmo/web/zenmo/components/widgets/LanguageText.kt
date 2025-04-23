package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.services.localization.LocalLanguage
import org.jetbrains.compose.web.dom.Text

@Composable
fun LangText(
    en: String? = null,
    nl: String? = null,
) {
    val language = LocalLanguage.current
    Text(language.translate(en = en, nl = nl))
}


