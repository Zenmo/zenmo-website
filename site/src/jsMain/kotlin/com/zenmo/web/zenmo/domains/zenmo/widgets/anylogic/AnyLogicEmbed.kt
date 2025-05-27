package com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.aspectRatio
import com.varabyte.kobweb.compose.ui.modifiers.maxHeight
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.coroutines.await
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Div
import kotlin.js.Promise
import kotlin.uuid.Uuid

/**
 * API key of user publiek@zenmo.com for use with publicly available models
 */
val anyLogicPublicApiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710")

val AnyLogicEmbedStyle = CssStyle {
    base {
        Modifier
            // AnyLogic elements use absolute positioning.
            // This makes those elements relative to this parent.
            .position(Position.Relative)
            // Make sure it fits on the screen.
            // Reserve space for site header.
            .maxHeight(80.vh)
            .width(100.percent)
            // 8:5 Approaches the default aspect ratio in AnyLogic.
            // It is possible to create a model for a different aspect ratio.
            .aspectRatio(8, 5)
    }
}

/**
 * Embed a simulation from AnyLogic Cloud
 */
@Composable
fun AnyLogicEmbed(
    modifier: Modifier = Modifier,
    modelId: Uuid,
    apiKey: Uuid = anyLogicPublicApiKey,
    cloudUrl: String = "https://anylogic.zenmo.com",
) {
    val containerId = remember { "anylogic-embed-${randomString(4u)}" }

    LaunchedEffect(modelId) {
        dynamicImport<Unit>("https://anylogic.zenmo.com/assets/js-client-8.5.0/cloud-client.js")
        val client = CloudClient.create(apiKey.toHexDashString(), cloudUrl)
        val model = client.getModelById(modelId.toHexDashString()).await()
        val modelVersion = client.getLatestModelVersion(model).await()
        val inputs = client.createDefaultInputs(modelVersion)
        client.startAnimation(inputs, containerId).await()
    }

    Div(
        attrs = AnyLogicEmbedStyle
            .toModifier().then(modifier).toAttrs {
                id(containerId)
            }
    )
}

/**
 * This is a workaround to make browser imports work.
 * We can't use Webpack magic comment /* webpackIgnore: true */
 * because the Kotlin compiler strips all comments, even comments
 * in [kotlin.js.js]
 */
suspend fun <T> dynamicImport(library: String): T {
    val promise: Promise<T> = eval("import('$library')")
    return promise.await()
}

fun randomString(length: UInt): String {
    val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"

    return buildString {
        repeat(length.toInt()) {
            append(chars.random())
        }
    }
}
