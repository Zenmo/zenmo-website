package com.zenmo.web.zenmo.domains.zenmo.sections.component_demo

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.toAttrs
import com.zenmo.web.zenmo.components.widgets.ImageWithCaption
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.zenmo.widgets.ComponentDemo
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span


@Composable
fun ImageWithCaptionDemo() {
    ComponentDemo(
        enTitle = "Image With Caption",
        nlTitle = "Afbeelding Met Bijschrift",
        enDescription = """
            The following snippet creates an image with caption. The caption is a short text that 
            describes the image. This is useful for articles, or any content that requires visual support.
        """.trimIndent(),
        nlDescription = """
            De volgende snippet maakt een afbeelding met bijschrift. Het bijschrift is een korte tekst die 
            de afbeelding beschrijft. Dit is handig voor artikelen of elke inhoud die visuele ondersteuning vereist.
        """.trimIndent(),
        codeExample = """
            import com.zenmo.web.zenmo.components.widgets.ImageWithCaption
            
            ImageWithCaption(
                imageUrl = "avatars/Auke_Hoekstra.jpg",
                altText = "Auke Hoekstra",
                enCaptionText = "A photo of Auke Hoekstra, a well-known figure in the field of sustainable energy.",
                nlCaptionText = "Een foto van Auke Hoekstra, een bekende figuur op het gebied van duurzame energie.",
            )
            
        """.trimIndent(),
    ) {
        Column(Modifier.gap(1.cssRem)) {
            Div {
                Span(
                    Modifier
                        .fontWeight(FontWeight.Bold)
                        .toAttrs()
                ) {
                    LangText(
                        en = "Notes: ",
                        nl = "Opmerkingen: ",
                    )
                }
                LangText(
                    en = """The `imageUrl` should point to a valid image file, and the `altText` should 
                        describe the image for accessibility.
                    """.trimIndent(),
                    nl = """De `imageUrl` moet verwijzen naar een geldig afbeeldingsbestand, en de `altText` 
                        moet de afbeelding beschrijven voor toegankelijkheid.
                    """.trimIndent()
                )
            }
            ImageWithCaption(
                imageUrl = "avatars/Auke_Hoekstra.jpg",
                altText = "Auke Hoekstra",
                enCaptionText = "A photo of Auke Hoekstra, a well-known figure in the field of sustainable energy.",
                nlCaptionText = "Een foto van Auke Hoekstra, een bekende figuur op het gebied van duurzame energie.",
            )
        }
    }
}