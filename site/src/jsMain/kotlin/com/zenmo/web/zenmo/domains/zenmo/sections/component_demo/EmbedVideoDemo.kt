package com.zenmo.web.zenmo.domains.zenmo.sections.component_demo

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.zenmo.web.zenmo.components.widgets.EmbedVideo
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.zenmo.widgets.ComponentDemo
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Span

@Composable
fun EmbedVideoDemo() {
    ComponentDemo(
        enTitle = "Embed Video",
        nlTitle = "Ingesloten video",
        enDescription = """
            The snippet below allows you to embed a video on a page along with a title and description.
            Useful for showcasing video content directly within the page layout.
        """.trimIndent(),
        nlDescription = """
            De onderstaande snippet stelt je in staat om een video op een pagina in te sluiten, 
            samen met een titel en beschrijving. Handig voor het direct tonen van videocontent binnen 
            de paginalay-out.
        """.trimIndent(),
        codeExample = """
            import com.zenmo.web.zenmo.components.widgets.EmbedVideo
            
            EmbedVideo(
                videoScr = "https://www.youtube.com/embed/fq0VmRtPOOo",
                enTitle = "Virtual labs to get a grip on the energy transition",
                nlTitle = "Virtuele labs om grip te krijgen op de energietransitie",
                enDescriptionParagraph = ""${'"'}
                        At the Eindhoven University of Technology researchers have been developing modeling methods based 
                        on agent-based modeling to get a grip on complex systems.
                    ""${'"'}.trimIndent(),
                nlDescriptionParagraph = ""${'"'}
                        Aan de Technische Universiteit Eindhoven ontwikkelen onderzoekers modelleermethoden op basis van 
                        agent-gebaseerd modelleren om grip te krijgen op complexe systemen.
                    ""${'"'}.trimIndent(),
                reversed = true
            )
        """.trimIndent(),
        enCustomizationNotes = "Use `reversed` parameter to switch the order of the video and text content.",
        nlCustomizationNotes = "Gebruik de `reversed` parameter om de volgorde van de video en tekstinhoud te wisselen.",
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().gap(1.cssRem),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Span(
                Modifier.fillMaxWidth()
                    .textAlign(TextAlign.Start)
                    .toAttrs()
            ) {
                LangText(
                    en = "This code snippet results in the following:",
                    nl = "Deze code resulteert in het volgende:",
                )
            }

            EmbedVideo(
                videoScr = "https://www.youtube.com/embed/fq0VmRtPOOo",
                enTitle = "Virtual labs to get a grip on the energy transition",
                nlTitle = "Virtuele labs om grip te krijgen op de energietransitie",
                enDescriptionParagraph = """
                    At the Eindhoven University of Technology researchers have been developing modeling methods based 
                    on agent-based modeling to get a grip on complex systems.
                """.trimIndent(),
                nlDescriptionParagraph = """
                    Aan de Technische Universiteit Eindhoven ontwikkelen onderzoekers modelleermethoden op basis van 
                    agent-gebaseerd modelleren om grip te krijgen op complexe systemen.
                """.trimIndent(),
                reversed = false
            )
        }
    }
}