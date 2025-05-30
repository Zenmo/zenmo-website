package energy.lux.site.shared

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.js.JsExport
import kotlin.uuid.Uuid

@JsExport
@Serializable
data class UserInfo(
    val sub: Uuid,
    val preferred_username: String,
    val name: String? = null,
    val given_name: String? = null,
    val family_name: String? = null,
    val email: String? = null,
) {
    companion object {
        fun fromJson(jsonString: String) =
            Json.decodeFromString<UserInfo>(jsonString)
    }

    /**
     * Compress user to an acronym to display as a user icon
     */
    fun iconLetters(): String {
        val nameLetters = initialLetters(name)
        if (nameLetters.isNotEmpty()) return nameLetters

        return initialLetters(preferred_username.replaceAfter("@", ""))
    }
}

/**
 * Get the first letter of every word
 */
private fun initialLetters(str: String?): String {
    if (str == null) return ""

    return str.split("-", " ", "_")
        .map { it[0] }
        .joinToString("")
}
