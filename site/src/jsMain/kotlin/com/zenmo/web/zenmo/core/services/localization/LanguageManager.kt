package com.zenmo.web.zenmo.core.services.localization

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLElement
import org.w3c.dom.url.URLSearchParams


/**
 * Singleton object to manage the website's language responsibly.
 */
object LanguageManager {
    private const val LANGUAGE_MODE_KEY = "zenmo:site-lang"

    /** backing property for the current language state,
    initialized with the language from
    - local storage,
    - navigator, or
    - URL parameters */
    private val _language = mutableStateOf(getLanguage())

    val language: State<Language> get() = _language


    private fun getLanguageFromLocalStorage(): Language? {
        val storedLang = window.localStorage.getItem(LANGUAGE_MODE_KEY)
        return storedLang?.let { Language.fromCodeToLanguage(it) }
    }

    private fun getLanguageFromUrl(): Language? {
        val urlParams = URLSearchParams(window.location.search)
        val urlLang = urlParams.get("lang")?.trim()
        return urlLang?.let { Language.fromCodeToLanguage(it) }
    }

    private fun getLanguageFromNavigator(): Language {
        val navigatorLang = window.navigator.language
        return Language.fromCodeToLanguage(navigatorLang)
    }

    private fun getLanguage(): Language {
        return getLanguageFromLocalStorage()
            ?: getLanguageFromUrl()
            ?: getLanguageFromNavigator()
    }

    //Update current language, local storage and html "lang" attribute to reflect the change.
    // making this publicly available for testing purposes
    fun setLanguage(newLanguage: Language) {
        _language.value = newLanguage
        val langCode = Language.toCodeFromLanguage(newLanguage)
        window.localStorage.setItem(LANGUAGE_MODE_KEY, langCode)
        val htmlElement = document.documentElement as HTMLElement
        htmlElement.lang = langCode
    }

    fun toggleLanguage() = setLanguage(Language.toggleLanguage(_language.value))

}
