package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.core.Page
import com.zenmo.web.zenmo.components.widgets.anylogic.AnyLogicEmbed
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.Text
import kotlin.uuid.Uuid

/**
 * Page to demo the usage of components
 */
@Page
@Composable
fun ComponentDemoPage() {
    SectionContainer {
        H2 {
            Text("Demo of components")
        }
        H3 {
            Text("AnyLogicEmbed")
        }
        AnyLogicEmbed(
            modelId = Uuid.parse("c31871aa-a043-49e6-8d91-fef9b2fc4643"),
            apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
            modifier = Modifier.maxWidth(70.cssRem)
        )
        Pre {
            Text(
                """
                    import com.varabyte.kobweb.compose.ui.Modifier
                    import components.widgets.anylogic.AnyLogicEmbed
                    import kotlin.uuid.Uuid
                    
                    AnyLogicEmbed(
                        modelId = Uuid.parse("c31871aa-a043-49e6-8d91-fef9b2fc4643"),
                        apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                        modifier = Modifier.maxWidth(70.cssRem)
                    )
                """.trimIndent()
            )
        }
    }
}