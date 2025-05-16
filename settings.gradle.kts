pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}

plugins {
    // can't read from toml file, must hardcode
    kotlin("multiplatform") version "2.1.10" apply false
}

// The following block registers dependencies to enable Kobweb snapshot support. It is safe to delete or comment out
// this block if you never plan to use them.
gradle.settingsEvaluated {
    fun RepositoryHandler.kobwebSnapshots() {
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/") {
            content { includeGroupByRegex("com\\.varabyte\\.kobweb.*") }
            mavenContent { snapshotsOnly() }
        }
    }

    pluginManagement.repositories { kobwebSnapshots() }
    dependencyResolutionManagement.repositories { kobwebSnapshots() }
}

rootProject.name = "zenmo-website"

include(":site")
include(":remotedev")
