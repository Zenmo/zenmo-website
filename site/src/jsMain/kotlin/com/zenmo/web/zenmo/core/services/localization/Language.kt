package com.zenmo.web.zenmo.core.services.localization

sealed class Language {
    abstract fun translate(en: String?, nl: String?): String

    data object Dutch : Language() {
        override fun translate(en: String?, nl: String?): String = nl ?: en ?: ""
    }

    data object English : Language() {
        override fun translate(en: String?, nl: String?): String = en ?: nl ?: ""
    }

    /*todo we can have a companion object here
    *  to override the language for testing purposes
    * */
}