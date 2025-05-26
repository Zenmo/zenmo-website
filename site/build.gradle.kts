import com.github.gradle.node.npm.task.NpmTask
import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import org.gradle.api.internal.tasks.DefaultTaskContainer.TaskCreatingProvider
import org.jetbrains.kotlin.gradle.dsl.JsModuleKind

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
    id("com.dorongold.task-tree") version "4.0.1"
    id("com.github.node-gradle.node") version "7.1.0"
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
            scriptAttributes.put("type", "module")
        }

        globals.putAll(
            mapOf(
                "version" to project.version.toString(),
                "BACKEND_URL" to System.getenv("BACKEND_URL"),
                "LOCAL_DEV_ENV" to System.getenv("LOCAL_DEV_ENV"),
                "LUX_DOMAIN" to System.getenv("LUX_DOMAIN"),
                "ZENMO_DOMAIN" to System.getenv("ZENMO_DOMAIN"),
            )
        )
    }
}

kotlin {
    compilerOptions {
        compilerOptions.freeCompilerArgs.add("-Xir-per-file")
        compilerOptions.freeCompilerArgs.add("-Xir-minimized-member-names=false")
    }

    // This example is frontend only. However, for a fullstack app, you can uncomment the includeServer parameter
    // and the `jvmMain` source set below.
    configAsKobwebApplication("zenmo-site" /*, includeServer = true*/)

    js {
        browser()
        // Use binaries.library() instead of binaries.exectable()
        // We will use Rollup to bundle instead of the default Webpack
        binaries.library()
        useEsModules()
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions.target = "es2015"
                compilerOptions.moduleKind = JsModuleKind.MODULE_ES
            }
        }
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlin.uuid.ExperimentalUuidApi")
        }

        jsMain.dependencies {
            implementation("org.jetbrains.kotlin-wrappers:kotlin-web:2025.5.8")
            implementation("org.jetbrains.kotlin-wrappers:kotlin-js:2025.5.8")
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

node {
    nodeProjectDir = file("$projectDir/rollup")
}

tasks.register<NpmTask>("npmRollup") {
    args = listOf("run", "rollup")
    dependsOn("npmInstall", "jsBrowserProductionLibraryDistribution")
}

tasks.named<DefaultTask>("assemble") {
    dependsOn("npmRollup")
}

val webpackTasksToRemove = setOf(
    "jsBrowserDevelopmentWebpack",
    "jsBrowserProductionWebpack",
    "jsBrowserWebpack",
    // this depends on jsBrowserProductionWebpack
    // but I'm unable to remove that dependency.
    // It seems a special kind of copy task.
    "jsBrowserDistribution",
)

webpackTasksToRemove.forEach {
    tasks.named(it) {
        enabled = false
    }
}

project.afterEvaluate {
    // replace Webpack tasks with Rollup task
    tasks.forEach { task ->
        val newDependsOn = task.dependsOn.filterNot {
            return@filterNot (it is TaskCreatingProvider<*> && it.type == org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack::class.java)
                    || (it is TaskProvider<*> && it.name in webpackTasksToRemove)
                    || (it is String && it in webpackTasksToRemove)
        }

        if (task.dependsOn.size != newDependsOn.size) {
            task.setDependsOn(newDependsOn)
            task.dependsOn("npmRollup")
        }
    }
}
