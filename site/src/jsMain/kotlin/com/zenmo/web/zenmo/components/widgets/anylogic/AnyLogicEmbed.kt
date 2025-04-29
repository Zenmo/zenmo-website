package com.zenmo.web.zenmo.components.widgets.anylogic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.aspectRatio
import com.varabyte.kobweb.compose.css.functions.calc
import com.varabyte.kobweb.compose.css.height
import com.varabyte.kobweb.compose.css.margin
import kotlinx.coroutines.await
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.maxHeight
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement
import kotlin.js.Promise
import kotlin.uuid.Uuid

/**
 * API key of user publiek@zenmo.com for use with publicly available models
 */
val anyLogicPublicApiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710")

/**
 * Embed a simulation from AnyLogic Cloud
 */
@Composable
fun AnyLogicEmbed(
    modelId: Uuid,
    apiKey: Uuid = anyLogicPublicApiKey,
    cloudUrl: String = "https://anylogic.zenmo.com",
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
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

    Div(attrs = {
        id(containerId)
        style {
            // AnyLogic elements use absolute positioning.
            // This makes those elements relative to this parent.
            position(Position.Relative)
            aspectRatio(8, 5)
            maxHeight(80.vh) // reserve space for site header
        }
        attrs?.invoke(this)
    })
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
