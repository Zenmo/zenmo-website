package com.zenmo.web.zenmo.domains.lux.widgets.headings

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.font.TitleTextStyle
import org.jetbrains.compose.web.dom.H3

@Composable
fun SubHeaderText(
    modifier: Modifier = Modifier,
    enText: String,
    nlText: String,
) {
    H3(
        TextStyle.toModifier(TitleTextStyle)
            .then(modifier)
            .toAttrs()
    ) {
        LangText(
            en = enText,
            nl = nlText,
        )
    }
}