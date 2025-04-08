package com.zenmo.web.zenmo.core.services.localization

import com.zenmo.web.zenmo.core.data.StringRes

interface Localization {
    fun getLocalizedString(resValue: StringRes, locale: Local): String
}