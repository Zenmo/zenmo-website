package energy.lux.site.shared

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.js.JsExport

private val format = Json { prettyPrint = true }

@JsExport
@Serializable
sealed class AccessPolicy {
    @Serializable
    class Public : AccessPolicy()

    @Serializable
    class RoleBased(
        val requiredRole: String,
    ) : AccessPolicy()

    fun toJson(): String {
        return format.encodeToString(this)
    }

    companion object {
        fun fromJson(json: String): AccessPolicy {
            return Json.decodeFromString(json)
        }
    }
}
