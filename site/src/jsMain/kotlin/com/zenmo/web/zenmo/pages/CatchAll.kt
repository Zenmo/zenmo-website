package com.zenmo.web.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.components.widgets.LangText
import org.jetbrains.compose.web.dom.P

@Page("{...catch-all}")
@Composable
fun CatchAllPage() {
    PageLayout("Pagina bestaat niet") {
        P {
            LangText(
                en = "This page does not exist",
                nl = "Deze pagina bestaat niet"
            )
        }
    }
}
