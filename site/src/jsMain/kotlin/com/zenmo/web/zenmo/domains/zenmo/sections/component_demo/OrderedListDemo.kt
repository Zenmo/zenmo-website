package com.zenmo.web.zenmo.domains.zenmo.sections.component_demo

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.OrderedList
import com.zenmo.web.zenmo.domains.zenmo.widgets.ComponentDemo

@Composable
fun OrderedListDemo() {
    ComponentDemo(
        enTitle = "Ordered List",
        nlTitle = "Geordende Lijst",
        enDescription = """
            This component renders an ordered list of items. Each item can be a composable function that returns the content of the list item.
            This could be regular text, links, or any other composable content. For simplicity, use this for just text items, links and maybe
            nested lists.
        """.trimIndent(),
        nlDescription = """
            Deze component rendert een geordende lijst van items. Elk item kan een composable functie zijn die de inhoud van het lijstitem retourneert.
            Dit kan gewone tekst, links of andere composable inhoud zijn. Gebruik dit voor eenvoud voor alleen tekstitems, links en misschien
            geneste lijsten.
        """.trimIndent(),
        codeExample = """
                    import com.zenmo.web.zenmo.components.widgets.LangText
                    import com.zenmo.web.zenmo.components.widgets.OrderedList
                    
                    OrderedList(
                        listOf(
                            { LangText(en = "First item", nl = "Eerste item") },
                            { LangText(en = "Second item", nl = "Tweede item") },
                        )
                    )              
                """.trimIndent(),
    ) {
        OrderedList(
            listOf(
                { LangText(en = "First item", nl = "Eerste item") },
                { LangText(en = "Second item", nl = "Tweede item") },
            )
        )
    }
}