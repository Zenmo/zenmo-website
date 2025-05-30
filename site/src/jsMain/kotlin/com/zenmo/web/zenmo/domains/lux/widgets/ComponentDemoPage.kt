package com.zenmo.web.zenmo.domains.lux.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.theme.font.DisplayTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Span

@Composable
fun ComponentDemoPage() {
    SectionContainer {
        Span(
            TextStyle.toModifier(DisplayTextStyle)
                .padding(top = 2.cssRem)
                .toAttrs()
        ) {
            LangText(
                en = "Demo of Components",
                nl = "Demo van Componenten",
            )
        }
    }
}
