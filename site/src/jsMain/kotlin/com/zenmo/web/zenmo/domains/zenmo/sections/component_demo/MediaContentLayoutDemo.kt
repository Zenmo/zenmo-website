package com.zenmo.web.zenmo.domains.zenmo.sections.component_demo

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.widgets.ComponentDemo
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.PrimaryButton
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.OutlinePrimaryButtonStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.P

@Composable
fun MediaContentLayoutDemo() {
    ComponentDemo(
        enTitle = "Media content Layout",
        nlTitle = "Media-inhoudindeling",
        enDescription = """
            Create a responsive two column layout with image and text with this code snippet. This is 
            useful for displaying things like the different purposes of the labs we make for authorities, 
            mobility and others.
        """.trimIndent(),
        nlDescription = """
            Maak een responsieve tweekolomsindeling met afbeelding en tekst met deze code. Dit is 
            handig voor het weergeven van dingen zoals de verschillende doeleinden van de labs die we maken voor autoriteiten, 
            mobiliteit en anderen.
        """.trimIndent(),
        codeExample = """
            import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
            import com.varabyte.kobweb.compose.ui.Modifier
            import com.varabyte.kobweb.compose.ui.modifiers.color
            import com.varabyte.kobweb.silk.style.toModifier
            import com.zenmo.web.zenmo.components.widgets.LangText
            import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
            import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
            import com.zenmo.web.zenmo.domains.zenmo.widgets.button.PrimaryButton
            import com.zenmo.web.zenmo.theme.SitePalette
            import com.zenmo.web.zenmo.theme.styles.OutlinePrimaryButtonStyle
            import org.jetbrains.compose.web.dom.P
            
            MediaContentLayout(
                imageUrl = "avatars/Auke_Hoekstra.jpg",
                title = {
                    HeaderText(
                        enText = "Media Content Layout",
                        nlText = "Media Inhoudsindeling",
                        modifier = Modifier.margin(0.cssRem)
                    )
                },
                subtitle = {
                    SubHeaderText(
                        enText = "Media item",
                        nlText = "Media -item",
                        modifier = Modifier.color(SitePalette.light.primary)
                            .margin(0.cssRem)
                    )
                },
                description = {
                    P {
                        LangText(
                            en = "This is an example of a media content layout with an image on the left and text on the right.",
                            nl = "Dit is een voorbeeld van een media-inhoudsindeling met een afbeelding aan de linkerkant en tekst aan de rechterkant.",
                        )
                    }
                },
                actionText = {
                    PrimaryButton(
                        modifier = OutlinePrimaryButtonStyle.toModifier(),
                        enText = "Learn more",
                        nlText = "Meer leren",
                        onClick = {}
                    )
                },
                reversed = false,
            )
            
        """.trimIndent(),
        enCustomizationNotes = """
            Use `reversed` to swap the position of the image and text content. 
            When set to false, the image content comes before the text content and vice versa. 
        """.trimIndent(),
        nlCustomizationNotes = """
            Gebruik `reversed` om de positie van de afbeelding en de tekstinhoud om te wisselen. 
            Wanneer ingesteld op false, komt de afbeeldinginhoud voor de tekstinhoud en vice versa.
        """.trimIndent()
    ) {
        MediaContentLayout(
            imageUrl = "avatars/Auke_Hoekstra.jpg",
            title = {
                HeaderText(
                    enText = "Media Content Layout",
                    nlText = "Media Inhoudsindeling",
                    // don't know why this is, but there's an extra topBottom margin
                    // on every text element which isn't needed
                    modifier = Modifier.margin(0.cssRem)
                )
            },
            subtitle = {
                SubHeaderText(
                    enText = "Media item",
                    nlText = "Media -item",
                    modifier = Modifier.color(SitePalette.light.primary)
                        .margin(0.cssRem)
                )
            },
            description = {
                P {
                    LangText(
                        en = "This is an example of a media content layout with an image on the left and text on the right.",
                        nl = "Dit is een voorbeeld van een media-inhoudsindeling met een afbeelding aan de linkerkant en tekst aan de rechterkant.",
                    )
                }
            },
            actionText = {
                PrimaryButton(
                    modifier = OutlinePrimaryButtonStyle.toModifier(),
                    enText = "Learn more",
                    nlText = "Meer leren",
                    onClick = {}
                )
            },
            reversed = false,
        )
    }
}