package com.zenmo.web.zenmo.domains.zenmo.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiTipsAndUpdates
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.LabelLargeTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.font.TitleTextStyle
import com.zenmo.web.zenmo.theme.styles.IconStyle
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*


val PreCodeStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(1.cssRem)
            .margin(bottom = 1.cssRem)
            .borderRadius(4.px)
            .backgroundColor(SitePalette.light.onBackground)
            .color(SitePalette.light.surface)
            .overflow { x(Overflow.Auto) }
    }
}
val CodeStyle = CssStyle {
    base {
        Modifier
            .fontWeight(FontWeight.Bold)
    }
}

val DemoContentWrapperStyle = CssStyle {
    base {
        Modifier
            .margin(top = 0.5.em)
            .background(
                color = Color.lightgray,
            )
            .borderRadius(4.px)
            .padding(1.cssRem)
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
    extraCustomizationContent: @Composable (() -> Unit)? = null,
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

        if (!enCustomizationNotes.isNullOrBlank()) {
            CustomizationNotes(
                enCustomizationNotes = enCustomizationNotes,
                nlCustomizationNotes = nlCustomizationNotes ?: enCustomizationNotes,
                customContent = extraCustomizationContent,
            )
        }
    }
}


@Composable
fun CustomizationNotes(
    enCustomizationNotes: String,
    nlCustomizationNotes: String,
    customContent: @Composable (() -> Unit)? = null,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .margin(top = 0.5.em)
            .background(
                color = SitePalette.light.surfaceContainerLow,
            )
            .color(SitePalette.light.primary)
            .borderRadius(4.px)
            .padding(1.cssRem, 2.cssRem),
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
        ) {
            Box {
                MdiTipsAndUpdates(
                    IconStyle.toModifier()
                        .color(SitePalette.light.primary)
                )
            }
            Div(
                TextStyle.toModifier(LabelLargeTextStyle)
                    .fillMaxWidth()
                    .margin(left = 0.5.cssRem)
                    .toAttrs()
            ) {
                Span(
                    Modifier
                        .fontWeight(FontWeight.Bold)
                        .toAttrs()
                ) {
                    LangText(
                        en = "Customization Options: ",
                        nl = "Aanpassingsopties: ",
                    )
                }
                Span {
                    LangText(
                        en = enCustomizationNotes,
                        nl = nlCustomizationNotes,
                    )
                }
                customContent?.invoke()
            }
        }
    }
}