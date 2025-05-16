package com.zenmo.web.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.components.sections.component_demo.PageHeadingsDemo
import com.zenmo.web.zenmo.components.sections.component_demo.SubHeadingsDemo
import com.zenmo.web.zenmo.components.sections.component_demo.TextParagraphsDemo
import com.zenmo.web.zenmo.components.widgets.ComponentDemo
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.components.widgets.SectionContainerStyle
import com.zenmo.web.zenmo.components.widgets.anylogic.AnyLogicEmbed
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import kotlin.uuid.Uuid


val DemoPageContainerVariant = SectionContainerStyle.addVariant {
    base {
        Modifier
            .fillMaxWidth()
            .margin(topBottom = 2.cssRem)
            .padding(leftRight = 4.cssRem)
    }

    Breakpoint.MD {
        Modifier
            .width(90.percent)
    }
    Breakpoint.LG {
        Modifier
            .width(75.percent)
    }

    Breakpoint.XL {
        Modifier
            .width(75.percent)
    }
}

/**
 * Page to demo the usage of components
 */
@Page
@Composable
fun ComponentDemoPage() {
    PageLayout("Demo of components") {
        H2 {
            Text("Demo of components")
        }
        SectionContainer(
            modifier = Modifier
                .margin(topBottom = 2.cssRem)
                .padding(leftRight = 4.cssRem),
            variant = DemoPageContainerVariant,
            verticalArrangement = Arrangement.spacedBy(4.cssRem)
        ) {
            PageHeadingsDemo()
            SubHeadingsDemo()
            TextParagraphsDemo()
            ComponentDemo(
                enTitle = "AnyLogic Embed",
                nlTitle = "AnyLogic embed",
                enDescription = "To show a simulation with AnyLogic, use the AnyLogicEmbed component.",
                nlDescription = "Om een simulatie met AnyLogic te tonen, gebruik de AnyLogicEmbed component.",
                codeExample = """
                    import com.varabyte.kobweb.compose.ui.Modifier
                    import com.zenmo.web.zenmo.components.widgets.anylogic.AnyLogicEmbed
                    import kotlin.uuid.Uuid
                    
                    AnyLogicEmbed(
                        modelId = Uuid.parse("c31871aa-a043-49e6-8d91-fef9b2fc4643"),
                        apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                        modifier = Modifier.maxWidth(70.cssRem)
                    )
                """.trimIndent(),
                enCustomizationNotes = "The width and height of this component can be customized using Modifier.",
                nlCustomizationNotes = "De breedte en hoogte van deze component kunnen worden aangepast met Modifier.",
            ) {
                AnyLogicEmbed(
                    modelId = Uuid.parse("c31871aa-a043-49e6-8d91-fef9b2fc4643"),
                    apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                    modifier = Modifier.maxWidth(70.cssRem)
                )
            }
        }
    }
}
