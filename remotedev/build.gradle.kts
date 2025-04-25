plugins {
    id("com.gradleup.shadow") version "9.0.0-beta12"
    kotlin("jvm") version "2.1.10"
}

group = "com.zenmo.remotedev"
version = "unspecified"

repositories {
    mavenCentral()
}



dependencies {
    testImplementation(kotlin("test"))
}

tasks.shadowJar {
    manifest {
        attributes(
            mapOf(
                "Main-Class" to "com.zenmo.remotedev.MainKt"
            )
        )
    }
}

kotlin {
    jvmToolchain(21)
}
