package com.zenmo.web.zenmo.domains.lux.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.zenmo.web.zenmo.components.widgets.LangText
import org.jetbrains.compose.web.dom.H1

@Composable
fun LuxHomePage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H1 {
            LangText(
                en = "LUX is Coming😎",
                nl = "LUX komt eraan😎"
            )
        }
        Link("/about") {
            LangText(
                en = "Click here",
                nl = "Klik hier",
            )
        }
    }
}