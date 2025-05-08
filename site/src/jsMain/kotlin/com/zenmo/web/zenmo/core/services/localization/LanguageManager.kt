package com.zenmo.web.zenmo.core.services.localization

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.browser.document


/**
 * Singleton object to manage the website's language responsibly.
 */
object LanguageManager {
    // backing property for the current language state, initialized with the default language.
    private val _language = mutableStateOf(initializeLanguage())

    val language: State<Language> get() = _language

    /**
     * Initializes the language based on 3 sources:
     * - Local storage (if available)
     * - Browser's navigator language
     * - URL parameters (if a "lang" parameter is provided)
     */
    private fun initializeLanguage(): Language {
        val provider = DefaultBrowserLanguageProvider
        var language = provider.getLocalStorageLanguage() ?: provider.getNavigatorLanguage()

        val urlParams = provider.getUrlParams()
        val urlLang = urlParams.get("lang")
        urlLang?.let {
            val lang = it.trim()
            if (lang.isNotBlank()) {
                language = lang
            }
        }

        //fallback Dutch if no valid language is found.
        val local = when {
            language.startsWith("en") -> Language.English
            else -> Language.Dutch
        }
        provider.setLocalStorageLanguage(
            when (local) {
                Language.English -> "en"
                Language.Dutch -> "nl"
            }
        )
        provider.setHtmlLang(
            when (local) {
                Language.English -> "en"
                Language.Dutch -> "nl"
            }
        )
        return local
    }

    //Update current language, local storage and html "lang" attribute to reflect the change.
    fun setLanguage(newLanguage: Language) {
        _language.value = newLanguage
        DefaultBrowserLanguageProvider.setLocalStorageLanguage(
            when (newLanguage) {
                Language.English -> "en"
                Language.Dutch -> "nl"
            }
        )
        document.documentElement?.setAttribute(
            "lang", when (newLanguage) {
                Language.English -> "en"
                Language.Dutch -> "nl"
            }
        )
    }

    fun toggleLanguage() = setLanguage(Language.toggleLanguage(_language.value))

}
