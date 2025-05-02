package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
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

const val PAGE_SECTION_CONTAINER_CLASSNAME = "page-section-container"

val PageSectionContainerStyle = CssStyle<SectionComponentKind> {
    base {
        Modifier
            .width(100.percent)
            .height(auto)
            .maxWidth(130.cssRem)
            .classNames(PAGE_SECTION_CONTAINER_CLASSNAME)
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
 * [PageContainer] should be used when you need:
 * - a container that automatically adapts to different breakpoints
 * - a standardized container for responsive page sections with consistent padding
 *
 * Typical usage includes:
 * - Main page sections in the website
 * - Content blocks that need a responsive behavior
 */

@Composable
fun PageContainer(
    modifier: Modifier = Modifier,
    pageSectionId: String? = null,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    variant: CssStyleVariant<SectionComponentKind>? = null,
    content: @Composable ColumnScope.() -> Unit = {},
) {
    val finalModifier = PageSectionContainerStyle.toModifier(variant)
        .then(modifier)
        .let { if (pageSectionId != null) it.id(pageSectionId) else it }

    Column(
        modifier = finalModifier,
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement,
        content = content
    )
}