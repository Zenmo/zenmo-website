package com.zenmo.web.zenmo.core.services.localization

import androidx.compose.runtime.compositionLocalOf
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLElement
import org.w3c.dom.url.URLSearchParams

val defaultLanguageLocal: Language by lazy {
    var language = window.navigator.language

    val urlParams = URLSearchParams(window.location.search)
    /* todo? im thinking of separating this logic
    *    from direct browser calls to make it easier to test
    * */
    val urlLang = urlParams.get("lang")
    urlLang?.let {
        val lang = it.trim()
        if (lang.isNotBlank()) {
            language = lang
        }
    }

    val local = when {
        language.startsWith("en") -> Language.English
        language.startsWith("nl") -> Language.Dutch
        else -> Language.English
    }
    val htmlElement = document.documentElement as HTMLElement
    htmlElement.lang = language

    local
}

val LocalLanguage = compositionLocalOf<Language> { error("Unknown Language") }

