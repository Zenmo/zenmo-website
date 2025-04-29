package com.zenmo.web.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.components.widgets.anylogic.AnyLogicEmbed
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import kotlin.uuid.Uuid

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
        H3 {
            Text("AnyLogicEmbed")
        }
        P {
            Text("com.zenmo.web.zenmo.components.widgets.anylogic.AnyLogicEmbed")
        }
        AnyLogicEmbed(
            modelId = Uuid.parse("c31871aa-a043-49e6-8d91-fef9b2fc4643"),
            apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
            attrs = {
                style {
                    height(40.cssRem)
                }
            }
        )
    }
}
