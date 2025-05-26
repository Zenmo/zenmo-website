package com.zenmo.web.zenmo.domains.zenmo.sections.component_demo

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.zenmo.widgets.ComponentDemo
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Span

@Composable
fun PageHeadingsDemo() {
    ComponentDemo(
        enTitle = "Page Headings",
        nlTitle = "Pagina koppen",
        enDescription = "Use this to display very large/prominent headlines on a page.",
        nlDescription = "Gebruik dit om zeer grote krantenkoppen op een pagina weer te geven.",
        codeExample = """
                    import com.zenmo.web.zenmo.components.widgets.LangText
                    import org.jetbrains.compose.web.dom.H1
                    
                    H1{
                        LangText(
                            en = "Welcome to the show!",
                            nl = "Welkom bij de show!",
                        )
                    }
                """.trimIndent(),
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
                    en = "This code gives the following heading result:",
                    nl = "Deze code geeft het volgende kop resultaat:",
                )
            }
            H1 {
                LangText(
                    en = "Welcome to the show!",
                    nl = "Welkom bij de show!",
                )
            }
        }
    }
}