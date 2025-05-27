package com.zenmo.web.zenmo.domains.zenmo.sections.component_demo

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.zenmo.widgets.ComponentDemo
import com.zenmo.web.zenmo.domains.zenmo.widgets.DemoContentWrapperStyle
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span

@Composable
fun TextParagraphsDemo() {
    ComponentDemo(
        enTitle = "Text Paragraphs",
        nlTitle = "Sub koppen",
        enDescription = "Use this pattern for standard text content.  Paragraphs provide the main body of text on a page.",
        nlDescription = "Gebruik dit patroon voor standaard tekstinhoud.  Paragrafen vormen de hoofdtekst op een pagina.",
        codeExample = """
                    import com.zenmo.web.zenmo.components.widgets.LangText
                    import com.varabyte.kobweb.silk.components.text.P
                    
                    P {
                        LangText(
                            en = "The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog.",
                            nl = "De snelle bruine vos springt over de luie hond. De snelle bruine vos springt over de luie hond.",
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
                DemoContentWrapperStyle.toModifier()
                    .toAttrs()
            ) {
                P {
                    LangText(
                        en = "The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog.",
                        nl = "De snelle bruine vos springt over de luie hond. De snelle bruine vos springt over de luie hond.",
                    )
                }
            }
        }
    }
}