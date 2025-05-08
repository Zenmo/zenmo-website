package com.zenmo.web.zenmo.core.services.localization

import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLElement
import org.w3c.dom.url.URLSearchParams

interface BrowserLanguageProvider {
    fun getNavigatorLanguage(): String
    fun setHtmlLang(lang: String)
    fun getUrlParams(): URLSearchParams
    fun getLocalStorageLanguage(): String?
    fun setLocalStorageLanguage(lang: String)
}


object DefaultBrowserLanguageProvider : BrowserLanguageProvider {
    override fun getNavigatorLanguage(): String = window.navigator.language
    override fun setHtmlLang(lang: String) {
        val htmlElement = document.documentElement as HTMLElement
        htmlElement.lang = lang
    }

    override fun getUrlParams(): URLSearchParams = URLSearchParams(window.location.search)

    override fun getLocalStorageLanguage(): String? = window.localStorage.getItem(Language.LANGUAGE_MODE_KEY)

    override fun setLocalStorageLanguage(lang: String) = window.localStorage.setItem(Language.LANGUAGE_MODE_KEY, lang)
}