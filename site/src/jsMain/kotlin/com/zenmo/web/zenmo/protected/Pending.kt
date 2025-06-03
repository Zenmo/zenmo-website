package com.zenmo.web.zenmo.protected

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.LoadingSpinner
import org.jetbrains.compose.web.css.cssRem

@Composable
fun Pending() {
    Column(
        modifier = Modifier.fillMaxWidth().gap(0.05.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoadingSpinner()
        LangText(
            en = "Hang on, just a moment.",
            nl = "Even geduld, een momentje."
        )
    }
}
