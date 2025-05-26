package com.zenmo.web.zenmo.domains.zenmo.sections.component_demo

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.zenmo.web.zenmo.domains.zenmo.widgets.ComponentDemo
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import org.jetbrains.compose.web.css.cssRem
import kotlin.uuid.Uuid

@Composable
fun AnyLogicDemo() {
    ComponentDemo(
        enTitle = "AnyLogic Embed",
        nlTitle = "AnyLogic embed",
        enDescription = "To show a simulation with AnyLogic, use the AnyLogicEmbed component.",
        nlDescription = "Om een simulatie met AnyLogic te tonen, gebruik de AnyLogicEmbed component.",
        codeExample = """
                    import com.varabyte.kobweb.compose.ui.Modifier
                    import components.widgets.anylogic.AnyLogicEmbed
                    import kotlin.uuid.Uuid
                    
                    AnyLogicEmbed(
                        modelId = Uuid.parse("c31871aa-a043-49e6-8d91-fef9b2fc4643"),
                        apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                        modifier = Modifier.maxWidth(70.cssRem)
                    )
                """.trimIndent(),
        enCustomizationNotes =
            """
                You may want to change the size of the simulation.
                Use modifiers like `width`, `height`, `maxWidth`, and
                `maxHeight` to adjust the size of the simulation.
                """.trimIndent(),
        nlCustomizationNotes = """
                Je wilt misschien de grootte van de simulatie veranderen.
                Gebruik modifiers zoals `width`, `height`, `maxWidth` en
                `maxHeight` om de grootte van de simulatie aan te passen.
        """.trimIndent()
    ) {
        AnyLogicEmbed(
            modelId = Uuid.parse("c31871aa-a043-49e6-8d91-fef9b2fc4643"),
            apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
            modifier = Modifier.maxWidth(70.cssRem)
        )
    }
}