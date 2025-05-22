package com.zenmo.web.zenmo.components.sections.component_demo

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.ComponentDemo
import com.zenmo.web.zenmo.components.widgets.DemoContentWrapperStyle
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.font.TitleTextStyle
import org.jetbrains.compose.web.dom.Span

@Composable
fun SubHeadingsDemo() {
    ComponentDemo(
        enTitle = "Sub Headings",
        nlTitle = "Sub koppen",
        enDescription = "You typically use this when you want to display a subheading on a page.",
        nlDescription = "Je gebruikt dit meestal wanneer je een subkop op een pagina wilt tonen.",
        codeExample = """
                    import com.zenmo.web.zenmo.components.widgets.LangText
                    import com.zenmo.web.zenmo.theme.font.TitleTextStyle
                    import com.varabyte.kobweb.compose.ui.toAttrs
                    import com.varabyte.kobweb.silk.components.text.Span
                    import com.varabyte.kobweb.silk.style.toModifier
                    
                    Span(
                        TextStyle.toModifier(TitleTextStyle)
                            .toAttrs()
                    ) {
                        LangText(
                             en = "Explore",
                            nl = "Verken",
                        )
                    }
                """.trimIndent()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Span(
                Modifier.fillMaxWidth()
                    .textAlign(TextAlign.Start)
                    .toAttrs()
            ) {
                LangText(
                    en = "This results in the following:",
                    nl = "Dit resulteert in het volgende:",
                )
            }
            Span(
                TextStyle.toModifier(TitleTextStyle)
                    .then(DemoContentWrapperStyle.toModifier())
                    .toAttrs()
            ) {
                LangText(
                    en = "Explore",
                    nl = "Verken",
                )
            }
        }
    }
}