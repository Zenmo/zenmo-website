package com.zenmo.web.zenmo.core.services.localization

import androidx.compose.runtime.compositionLocalOf


sealed class Language {
    abstract fun translate(en: String?, nl: String?): String

    data object Dutch : Language() {
        override fun translate(en: String?, nl: String?): String = nl ?: en ?: ""
    }

    data object English : Language() {
        override fun translate(en: String?, nl: String?): String = en ?: nl ?: ""
    }

    companion object {
        const val LANGUAGE_MODE_KEY = "zenmo:site-lang"

        fun toggleLanguage(current: Language): Language = when (current) {
            English -> Dutch
            Dutch -> English
        }
    }
}

val LocalLanguage = compositionLocalOf<Language> { error("Unknown Language") }