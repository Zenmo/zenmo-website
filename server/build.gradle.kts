plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    application
}

dependencies {
//    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.2")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")

    // to decode and validate Keycloak access tokens with user info.
    implementation("com.nimbusds:nimbus-jose-jwt:9.39.2")

    implementation("org.graalvm.polyglot:js:24.2.1")
    implementation("org.graalvm.polyglot:polyglot:24.2.1")

    implementation(platform("org.http4k:http4k-bom:6.9.1.0"))
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-server-undertow")
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-security-oauth")
    implementation("org.http4k:http4k-format-kotlinx-serialization")
}

application {
    mainClass = "com.zenmo.server.MainKt"
}

kotlin {
    sourceSets {
        all {
            languageSettings.optIn("kotlin.uuid.ExperimentalUuidApi")
            languageSettings.optIn("kotlin.time.ExperimentalTime")
        }
    }
}
