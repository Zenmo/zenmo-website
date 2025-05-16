package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.font.TitleTextStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text


val PreCodeStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(1.cssRem)
            .margin(bottom = 1.cssRem)
            .borderRadius(4.px)
            .backgroundColor(SitePalette.light.onBackground)
            .color(SitePalette.light.surface)
    }
}

@Composable
fun ComponentDemo(
    modifier: Modifier = Modifier.fillMaxWidth(),
    enTitle: String,
    nlTitle: String,
    enDescription: String,
    nlDescription: String,
    codeExample: String,
    enCustomizationNotes: String? = null,
    nlCustomizationNotes: String? = null,
    customizationContent: @Composable (() -> Unit)? = {
        if (!enCustomizationNotes.isNullOrBlank()) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
            ) {
                Span {
                    LangText(
                        en = "Customization Options",
                        nl = "Aanpassingsopties",
                    )
                }
                P {
                    LangText(
                        en = enCustomizationNotes,
                        nl = nlCustomizationNotes ?: enCustomizationNotes,
                    )
                }
            }
        }
    },
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(0.1.cssRem),
        horizontalAlignment = Alignment.Start,
    ) {
        Span(
            TextStyle.toModifier(TitleTextStyle)
                .fontWeight(FontWeight.Bold)
                .toAttrs()
        ) {
            LangText(
                en = enTitle,
                nl = nlTitle,
            )
        }

        P {
            LangText(
                en = enDescription,
                nl = nlDescription,
            )
        }

        Pre(
            attrs = PreCodeStyle.toAttrs()
        ) {
            Text(codeExample)
        }

        Box(
            modifier = Modifier.fillMaxWidth()
                .margin(topBottom = 0.5.cssRem),
            contentAlignment = Alignment.Center
        ) {
            content()
        }

        customizationContent?.invoke()
    }
}