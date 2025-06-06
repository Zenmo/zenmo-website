package com.zenmo.web.zenmo.domains.zenmo.sections.component_demo

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.functions.max
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.widgets.CodeStyle
import com.zenmo.web.zenmo.domains.zenmo.widgets.ComponentDemo
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.PrimaryButton
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.styles.OutlinePrimaryButtonStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.*

@Composable
fun MediaContentLayoutDemo() {
    ComponentDemo(
        enTitle = "Media content Layout",
        nlTitle = "Media-inhoudindeling",
        enDescription = """
            Create a responsive two column layout with image and text with this code snippet. This is 
            useful for displaying things like the different purposes of the labs we make for authorities, 
            mobility and others. This widget is also convenient to show mockups for energy systems accompanied by a 
            description of the system
        """.trimIndent(),
        nlDescription = """
            Maak een responsieve tweekolomsindeling met afbeelding en tekst met deze code snippet. Dit is 
            handig voor het weergeven van dingen zoals de verschillende doeleinden van de labs die we maken voor 
            autoriteiten, mobiliteit en anderen. Deze widget is ook handig om mockups van energiesystemen te tonen, 
            vergezeld van een beschrijving van het systeem.
        """.trimIndent(),
        codeExample = """
            import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
            import com.varabyte.kobweb.compose.ui.Modifier
            import com.varabyte.kobweb.compose.ui.modifiers.height
            import com.varabyte.kobweb.compose.ui.modifiers.margin
            import com.varabyte.kobweb.compose.css.functions.max
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
                imageModifier = Modifier.height(
                    max(
                        50.vh,
                        425.px
                    )
                ),
            )
            
        """.trimIndent(),
        enCustomizationNotes = """
            You only need to provide the content you need, for example, if you do not need a subtitle or title, 
            you can just leave it out.
        """.trimIndent(),
        nlCustomizationNotes = """
            Je hoeft alleen de inhoud te leveren die je nodig hebt, bijvoorbeeld als je geen ondertitel of titel 
            nodig hebt, kun je deze gewoon weglaten.
        """.trimIndent(),
        extraCustomizationContent = {
            Ul {
                Li {
                    LangText(
                        en = "Use ",
                        nl = "Gebruik ",
                    )
                    Code(CodeStyle.toAttrs()) {
                        Text("reversed")
                    }
                    LangText(
                        en = " to swap the position of the image and text content. When set to false, the image content comes before the text content and vice versa.",
                        nl = " om de positie van de afbeelding en de tekstinhoud om te wisselen. Wanneer ingesteld op false, komt de afbeeldinginhoud voor de tekstinhoud en vice versa.",
                    )
                }

                Li {
                    LangText(
                        en = "If you care about the height of your image, you may want to tamper with the ",
                        nl = "Als je om de hoogte van je afbeelding geeft, wil je misschien met de ",
                    )
                    Code(CodeStyle.toAttrs()) {
                        Text("imageModifier")
                    }
                    LangText(
                        en = """
                             parameter. This is a modifier that is applied to the image element. You can use it to set 
                            the height of the image, like in the snippet above; 
                        """.trimIndent(),
                        nl = """
                             parameter. Dit is een modifier die wordt toegepast op het afbeeldings element. Je kunt het gebruiken 
                            om de hoogte van de afbeelding in te stellen, zoals in de bovenstaande code; 
                        """.trimIndent()
                    )
                    Br()
                    Code(CodeStyle.toAttrs()) {
                        Text("Modifier.height(max(50.vh, 425.px))")
                    }
                    LangText(
                        en = " ensures the image is at least 425px tall, but can grow to fill 50% of the viewport height.",
                        nl = " zorgt ervoor dat de afbeelding minimaal 425px hoog is, maar kan groeien om 50% van de hoogte van het scherm in te vullen.",
                    )
                    Br()
                    LangText(
                        en = "However, if you do not care about any of that responsiveness, you could just do: ",
                        nl = "Als je echter niet om die responsiviteit geeft, kun je gewoon doen: ",
                    )
                    Code(CodeStyle.toAttrs()) {
                        Text("Modifier.height(200.px)")
                    }
                    LangText(
                        en = " to set the height of the image to 200px.",
                        nl = " om de hoogte van de afbeelding op 200px in te stellen.",
                    )
                }
            }
        }
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
            imageModifier = Modifier.height(
                max(
                    50.vh,
                    425.px
                )
            ),
        )
    }
}