plugins {
    kotlin("jvm")
//    kotlin("plugin.serialization")
    application
}

dependencies {
    implementation("org.graalvm.polyglot:js:24.2.1")
    implementation("org.graalvm.polyglot:polyglot:24.2.1")

    implementation(platform("org.http4k:http4k-bom:6.9.1.0"))
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-server-undertow")
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-security-oauth")
}

application {
    mainClass = "com.zenmo.server.MainKt"
}
