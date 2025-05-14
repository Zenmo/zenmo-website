import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "com.zenmo.web.zenmo"
version = "1.0.0"

kobweb {
    app {
        index {
            description.set("Powered by Kobweb")
            head.add {
                link(rel = "stylesheet", href = "/fonts/faces.css")
            }
        }
        globals.put(
            "version",
            project.version.toString()
        )
    }
}

kotlin {
    // This example is frontend only. However, for a fullstack app, you can uncomment the includeServer parameter
    // and the `jvmMain` source set below.
    configAsKobwebApplication("zenmo" /*, includeServer = true*/)

    sourceSets {
        all {
            languageSettings.optIn("kotlin.uuid.ExperimentalUuidApi")
        }

        jsMain.dependencies {
            implementation("org.jetbrains.kotlin-wrappers:kotlin-js:2025.4.16")
            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.mdi)
            implementation(libs.kobwebx.markdown)
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
