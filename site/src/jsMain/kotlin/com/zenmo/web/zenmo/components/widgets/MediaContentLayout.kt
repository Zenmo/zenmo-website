package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.functions.max
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.FitWidthImageVariant
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.extendedBy
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh


@Composable
fun MediaContentLayout(
    imageUrl: String,
    imageModifier: Modifier = Modifier,
    visualContent: @Composable () -> Unit = {
        ImageContent(imageUrl, imageModifier)
    },
    title: @Composable () -> Unit = {},
    description: @Composable () -> Unit = {},
    subtitle: @Composable () -> Unit = {},
    actionText: @Composable () -> Unit = {},
    reversed: Boolean = false,
) {
    val breakpoint = rememberBreakpoint()
    SimpleGrid(
        numColumns(base = 1, md = 2, lg = 2, xl = 2),
        modifier = Modifier
            .gap(if (breakpoint < Breakpoint.MD) 2.cssRem else 5.cssRem)
    ) {
        when (reversed) {
            true -> {
                TextContent(
                    title = title,
                    description = description,
                    subtitle = subtitle,
                    actionText = actionText,
                )
                visualContent()
            }

            false -> {
                visualContent()
                TextContent(
                    title = title,
                    description = description,
                    subtitle = subtitle,
                    actionText = actionText,
                )
            }
        }
    }
}


@Composable
private fun TextContent(
    title: @Composable () -> Unit,
    description: @Composable () -> Unit,
    subtitle: @Composable () -> Unit,
    actionText: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .gap(1.cssRem),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        subtitle()
        title()
        description()
        actionText()
    }
}


val ImageContentStyleVariant = FitWidthImageVariant.extendedBy {
    base {
        Modifier
            .borderRadius(30.px)
            .objectFit(ObjectFit.Cover)
            .height(
                max(
                    50.vh,
                    425.px
                )
            ) // ensures the image is at least 425px tall, but can grow to fill 50% of the viewport height
    }
}

@Composable
private fun ImageContent(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    Image(
        src = imageUrl,
        variant = ImageContentStyleVariant,
        modifier = modifier
    )
}