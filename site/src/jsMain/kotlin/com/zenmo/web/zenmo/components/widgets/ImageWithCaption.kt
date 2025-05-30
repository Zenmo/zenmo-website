package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P

val CaptionImageStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .height(425.px)
            .borderRadius(30.px)
            .objectFit(ObjectFit.Cover)
    }
}

@Composable
fun ImageWithCaption(
    enCaptionText: String,
    nlCaptionText: String,
    imageUrl: String,
    altText: String,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .gap(0.25.cssRem),
        horizontalAlignment = Alignment.End,
    ) {
        Image(
            src = imageUrl,
            alt = altText,
            modifier = CaptionImageStyle
                .toModifier()
        )
        P(
            Modifier
                .textAlign(TextAlign.Right)
                .width(75.percent)
                .margin(0.cssRem)
                .toAttrs()
        ) {
            LangText(
                en = enCaptionText,
                nl = nlCaptionText,
            )
        }
    }
}
