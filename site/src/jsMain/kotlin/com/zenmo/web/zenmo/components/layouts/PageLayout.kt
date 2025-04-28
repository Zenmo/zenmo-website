package com.zenmo.web.zenmo.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gridRow
import com.zenmo.web.zenmo.components.sections.Footer
import com.zenmo.web.zenmo.components.sections.nav_header.NavHeader
import kotlinx.browser.document


@Composable
fun PageLayout(title: String, content: @Composable ColumnScope.() -> Unit) {
    LaunchedEffect(title) {
        document.title = "Zenmo - $title"
    }
    Column(
        Modifier.fillMaxSize().gridRow(1),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        NavHeader()
        content()
    }
    Footer(Modifier.fillMaxWidth().gridRow(2))
}
