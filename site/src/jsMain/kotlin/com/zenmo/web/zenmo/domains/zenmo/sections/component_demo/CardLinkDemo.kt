package com.zenmo.web.zenmo.domains.zenmo.sections.component_demo

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.toAttrs
import com.zenmo.web.zenmo.components.widgets.CardLink
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.zenmo.widgets.ComponentDemo
import com.zenmo.web.zenmo.domains.zenmo.widgets.PreCodeStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.Text

@Composable
fun CardLinkDemo() {
    ComponentDemo(
        enTitle = "Card Links",
        nlTitle = "Kaart Links",
        enDescription = """
            The code snippet below demonstrates how to create a card link that leads to another page. 
            Use this to provide a concise summary of the content on the linked page, along with an image, a title and 
            optionally a description. Can be used to show an image of an area or map.
        """.trimIndent(),
        nlDescription = """
            De onderstaande code laat zien hoe je een kaartlink maakt die naar een andere pagina leidt. 
            Gebruik dit om een beknopte samenvatting van de inhoud op de gekoppelde pagina te geven, 
            samen met een afbeelding, een titel en optioneel een beschrijving. Kan worden gebruikt om een afbeelding 
            van een gebied of kaart te tonen.
        """.trimIndent(),
        codeExample = """
                    import com.zenmo.web.zenmo.components.widgets.CardLink
                    
                    CardLink(
                        url = "/",
                        imageUrl = "avatars/Auke_Hoekstra.jpg",
                        imageAltText = "Auke Hoekstra",
                        enTitle = "Auke Hoekstra",
                        nlTitle = "Auke Hoekstra",
                        enDescription = "Auke Hoekstra is a well-known figure in the field of sustainable energy.",
                        nlDescription = "Auke Hoekstra is een bekende figuur op het gebied van duurzame energie.",
                        modifier = Modifier.width(280.px)
                    )
                    
                """.trimIndent()
    ) {
        Column(
            modifier = Modifier.gap(1.cssRem),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CardLink(
                url = "/",
                imageUrl = "avatars/Auke_Hoekstra.jpg",
                imageAltText = "Auke Hoekstra",
                enTitle = "Auke Hoekstra",
                nlTitle = "Auke Hoekstra",
                enDescription = "Auke Hoekstra is a well-known figure in the field of sustainable energy.",
                nlDescription = "Auke Hoekstra is een bekende figuur op het gebied van duurzame energie.",
                modifier = Modifier.width(280.px)
            )
            P(
                Modifier.fillMaxWidth().toAttrs()
            ) {

                LangText(
                    en = """
                    Typically, you would use this component to display multiple items in a grid layout. 
                    Here's an example of how to do that:
                """.trimIndent(),
                    nl = """
                    Gewoonlijk zou je deze component gebruiken om meerdere items in een rasterlay-out weer te geven. 
                    Hier is een voorbeeld van hoe je dat doet:
                """.trimIndent(),
                )
            }

            Pre(
                attrs = PreCodeStyle.toAttrs()
            ) {
                Text(
                    """
                        import com.varabyte.kobweb.silk.components.layout.SimpleGrid
                        import com.varabyte.kobweb.silk.components.layout.numColumns
                        import com.zenmo.web.zenmo.components.widgets.CardLink
                        import com.varabyte.kobweb.compose.ui.Modifier
                        import com.varabyte.kobweb.compose.ui.modifiers.gap
                        
                        SimpleGrid(
                            numColumns(base = 1, md = 3, lg = 3, xl = 3),
                            modifier = Modifier.gap(1.cssRem),
                        ) {
                                CardLink(...)
                                CardLink(...)
                                CardLink(...)
                        }
                        
                    """.trimIndent()
                )
            }
            SimpleGrid(
                numColumns(base = 1, md = 3, lg = 3, xl = 3),
                modifier = Modifier.gap(1.cssRem),
            ) {
                repeat(3) { _ ->
                    CardLink(
                        url = "/",
                        imageUrl = "avatars/Auke_Hoekstra.jpg",
                        imageAltText = "Auke Hoekstra",
                        enTitle = "Auke Hoekstra",
                        nlTitle = "Auke Hoekstra",
                        enDescription = "Auke Hoekstra is a well-known figure in the field of sustainable energy.",
                        nlDescription = "Auke Hoekstra is een bekende figuur op het gebied van duurzame energie.",
                    )
                }
            }
        }
    }
}