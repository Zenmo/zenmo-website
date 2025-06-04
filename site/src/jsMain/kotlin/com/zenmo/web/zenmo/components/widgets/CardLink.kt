package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P

val CardLinkStyle = CssStyle {
    base {
        Modifier
            .borderRadius(24.px)
            .background(Color.white)
            .boxShadow(0.px, 2.px, 4.px, 0.px, rgba(0, 0, 0, 0.24f))
            .transition(Transition.group(setOf("box-shadow", "transform"), 350.ms, TransitionTimingFunction.Ease))
    }
    cssRule(":is(:hover, :focus)") {
        Modifier
            .boxShadow(0.px, 8.px, 10.px, 1.px, rgba(0, 0, 0, 0.2f))
            .transform { translateY((-8).px) }
    }

    cssRule("> div > .cardImage") {
        Modifier
            .fillMaxWidth()
            .height(140.px)
            .borderRadius(topRight = 24.px, topLeft = 24.px)
            .objectFit(ObjectFit.Cover)
    }
}

val LinkNoStyle = CssStyle {
    base {
        Modifier.color(SitePalette.light.onBackground)
    }
    hover {
        Modifier.textDecorationLine(TextDecorationLine.None)
    }
}

@Composable
fun CardLink(
    modifier: Modifier = Modifier,
    url: String,
    imageUrl: String = "",
    imageAltText: String = "",
    enTitle: String = "",
    nlTitle: String = "",
    enDescription: String = "",
    nlDescription: String = "",
) {
    Link(path = url, modifier = LinkNoStyle.toModifier()) {
        Column(
            CardLinkStyle.toModifier()
                .then(modifier),
        ) {
            Div(
                Modifier.fillMaxWidth().toAttrs()
            ) {
                Img(
                    src = imageUrl,
                    alt = imageAltText,
                    attrs = Modifier
                        .classNames("cardImage").toAttrs()
                )
            }

            Column(
                Modifier.padding(1.cssRem).gap(1.cssRem)
            ) {
                SubHeaderText(
                    enText = enTitle,
                    nlText = nlTitle,
                    modifier = Modifier.margin(0.cssRem)
                )
                P(
                    Modifier
                        .color(SitePalette.light.onBackground.lightened(0.5f))
                        .margin(0.cssRem)
                        .toAttrs()
                ) {
                    LangText(
                        en = enDescription,
                        nl = nlDescription,
                    )
                }
            }
        }
    }
}
