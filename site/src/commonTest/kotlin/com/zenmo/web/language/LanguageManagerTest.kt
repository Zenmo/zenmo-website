package com.zenmo.web.language

import com.zenmo.web.zenmo.core.services.localization.Language
import com.zenmo.web.zenmo.core.services.localization.LanguageManager
import kotlin.test.Test
import kotlin.test.assertEquals


class LanguageManagerTest {
    @Test
    fun TogglesLanguageFromEnglishToDutch() {
        LanguageManager.setLanguage(Language.English)
        LanguageManager.toggleLanguage()
        assertEquals(Language.Dutch, LanguageManager.language.value)
    }

}