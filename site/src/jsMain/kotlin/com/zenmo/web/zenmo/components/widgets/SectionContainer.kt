package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.CssStyleVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

sealed interface SectionComponentKind : ComponentKind


val SectionContainerStyle = CssStyle<SectionComponentKind> {
    base {
        Modifier
            .width(100.percent)
            .height(auto)
            .maxWidth(130.cssRem)
    }
    Breakpoint.ZERO {
        Modifier.padding(leftRight = 16.px)
    }
    Breakpoint.SM {
        Modifier.padding(leftRight = 28.px)
    }
    Breakpoint.MD {
        Modifier.padding(leftRight = 48.px)
    }
    Breakpoint.LG {
        Modifier.padding(leftRight = 94.px)
    }
    Breakpoint.XL {
        Modifier.padding(leftRight = 134.px)
    }
}


/**
 * [SectionContainer] should be used when you need:
 * - a container that automatically adapts to different breakpoints
 * - a standardized container for responsive page sections with consistent padding
 *
 * Typical usage includes:
 * - Main page sections in the website
 * - Content blocks that need a responsive behavior
 */

@Composable
fun SectionContainer(
    modifier: Modifier = Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    variant: CssStyleVariant<SectionComponentKind>? = null,
    content: @Composable ColumnScope.() -> Unit = {},
) {
    Column(
        modifier = SectionContainerStyle.toModifier(variant)
            .then(modifier),
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement,
        content = content
    )
}