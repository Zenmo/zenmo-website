package com.zenmo.web.zenmo.core.services.localization

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.core.data.StringRes
import com.zenmo.web.zenmo.core.services.localization.Local.Dutch
import com.zenmo.web.zenmo.core.services.localization.Local.English
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLElement
import org.w3c.dom.url.URLSearchParams

private val defaultLocal: Local by lazy {
    var language = window.navigator.language

    val urlParams = URLSearchParams(window.location.search)
    val urlLang = urlParams.get("lang")
    urlLang?.let {
        val lang = it.trim()
        if (lang.isNotBlank()) {
            language = lang
        }
    }

    val local = when {
        language.startsWith("en") -> English
        language.startsWith("nl") -> Dutch
        else -> Dutch
    }
    val htmlElement = document.documentElement as HTMLElement
    htmlElement.dir = local.dir.dirStr
    htmlElement.lang = language

    local
}

@Composable
fun stringResource(stringRes: StringRes): String {
    // browser  handles that recompositions on language change
    return LocalizationService.getInstance()
        .getLocalizedString(stringRes, defaultLocal)
}

/**
 * For composable events or non composable functions
 */
fun getStringResource(stringRes: StringRes): String {
    return LocalizationService.getInstance()
        .getLocalizedString(stringRes, defaultLocal)
}