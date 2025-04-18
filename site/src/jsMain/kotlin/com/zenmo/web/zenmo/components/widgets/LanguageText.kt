package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.zenmo.web.zenmo.core.services.localization.LocalLanguage

@Composable
fun LangText(
    en: String? = null,
    nl: String? = null,
    modifier: Modifier = Modifier,
) {
    val language = LocalLanguage.current
    SpanText(
        modifier = modifier,
        text = language.translate(en = en, nl = nl),
    )
}


