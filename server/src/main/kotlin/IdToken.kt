package com.zenmo.server

import com.nimbusds.jwt.SignedJWT
import energy.lux.site.shared.UserInfo
import kotlinx.serialization.KSerializer
import org.http4k.security.openid.IdToken
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import kotlin.uuid.Uuid

fun IdToken.decode(): IdTokenPayload {
    val payload = SignedJWT.parse(this.value).payload

    // to inspect all fields:
    //val root = Json.parseToJsonElement(payload.toString()).jsonObject
    return jsonDecoder.decodeFromString<IdTokenPayload>(payload.toString())
}

@Serializable
data class IdTokenPayload @OptIn(ExperimentalTime::class) constructor(
    val sub: Uuid,
    val preferred_username: String,
    val name: String? = null,
    val given_name: String? = null,
    val family_name: String? = null,
    val email: String? = null,
    @Serializable(with = UnixTimeSerializer::class)
    val iat: Instant,
    @Serializable(with = UnixTimeSerializer::class)
    val exp: Instant,
    /**
     * Map of client id to access attributes.
     * Example:
     *
     * "resource_access": {
     *     "zenmo-website": {
     *         "roles": [
     *             "Groote Lindt"
     *         ]
     *     },
     * }
     */
    val resource_access: Map<String, ResourceAccess>
) {
    fun toUserInfo() = UserInfo(
        sub = sub,
        preferred_username = preferred_username,
        name = name,
        given_name = given_name,
        family_name = family_name,
        email = email,
    )

    fun getRoles(clientId: String): List<String> =
        resource_access[clientId]?.roles ?: emptyList()
}

@Serializable
data class ResourceAccess(
    val roles: List<String>,
)

private val jsonDecoder = Json {
    ignoreUnknownKeys = true
}

@OptIn(ExperimentalTime::class)
private object UnixTimeSerializer : KSerializer<Instant> {
    override val descriptor = PrimitiveSerialDescriptor("UnixTime", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder)
            = Instant.fromEpochSeconds(decoder.decodeLong())

    override fun serialize(encoder: Encoder, value: Instant)
            = encoder.encodeLong(value.epochSeconds)
}
