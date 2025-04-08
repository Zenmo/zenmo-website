package com.zenmo.web.zenmo.core.services.localization

import org.jetbrains.compose.web.attributes.DirType


/**
 * Enum class representing the supported locales for the site.
 * @property value The locale code (e.g., "en", "nl").
 * @property dir The text direction associated with the locale (e.g., Ltr, Rtl).
 * */
enum class Local(
    val value: String,
    val dir: DirType
) {
    English("en", DirType.Ltr),
    Dutch("nl", DirType.Ltr),
}