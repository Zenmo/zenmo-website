package com.zenmo.web.zenmo.components.sections.component_demo

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.ComponentDemo
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.theme.font.DisplayTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Span

@Composable
fun PageHeadingsDemo() {
    ComponentDemo(
        enTitle = "Page Headings",
        nlTitle = "Pagina koppen",
        enDescription = "Use this when you want to display a very large/prominent headlines on a page.",
        nlDescription = "Gebruik dit wanneer je een grote/prominente koppen op een pagina wilt tonen.",
        codeExample = """
                    import com.zenmo.web.zenmo.components.widgets.LangText
                    import com.zenmo.web.zenmo.theme.font.DisplayTextStyle
                    import com.zenmo.web.zenmo.theme.font.TextStyle
                    import com.varabyte.kobweb.compose.ui.toAttrs
                    import com.varabyte.kobweb.silk.components.text.Span
                    import com.varabyte.kobweb.silk.style.toModifier
                    
                    Span(
                        TextStyle.toModifier(DisplayTextStyle)
                            .toAttrs()
                    ) {
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
            Span(
                TextStyle.toModifier(DisplayTextStyle)
                    .background(
                        color = Color.lightgray,
                    )
                    .borderRadius(4.px)
                    .padding(1.cssRem)
                    .toAttrs()
            ) {
                LangText(
                    en = "Welcome to the show!",
                    nl = "Welkom bij de show!",
                )
            }
        }
    }
}