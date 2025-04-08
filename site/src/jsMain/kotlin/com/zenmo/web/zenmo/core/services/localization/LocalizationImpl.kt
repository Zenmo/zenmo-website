package com.zenmo.web.zenmo.core.services.localization

import com.zenmo.web.zenmo.core.data.StringRes
import com.zenmo.web.zenmo.core.services.localization.Local.Dutch
import com.zenmo.web.zenmo.core.services.localization.Local.English

class LocalizationImpl : Localization {
    override fun getLocalizedString(resValue: StringRes, locale: Local): String {
        return when (locale) {
            English -> resValue.en
            Dutch -> resValue.nl
        }
    }
}