package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P

val CardLinkStyle = CssStyle {
    base {
        Modifier
            .borderRadius(24.px)
            .background(Color.white)
    }
    hover {
        Modifier
            .cursor(Cursor.Pointer)
            .boxShadow(
                offsetX = 0.px,
                offsetY = 4.px,
                blurRadius = 8.px,
                spreadRadius = 0.px,
                color = Color("#00000033")
            )
    }

    cssRule("> div > .cardImage") {
        Modifier
            .fillMaxWidth()
            .height(140.px)
            .borderRadius(24.px)
            .objectFit(ObjectFit.Cover)
            .padding(leftRight = 0.5.cssRem, top = 0.5.cssRem)
    }

    cssRule(":hover > div > .cardImage") {
        Modifier
            .borderRadius(topRight = 24.px, topLeft = 24.px)
            .padding(0.cssRem)
            .transition(
                Transition.of(
                    "border-radius",
                    200.ms,
                ),

                Transition.of(
                    "padding",
                    200.ms,
                ),
            )
    }
}


@Composable
fun CardLink(
    modifier: Modifier = Modifier,
    url: String,
    imageUrl: String,
    imageAltText: String,
    enTitle: String,
    nlTitle: String,
    enDescription: String,
    nlDescription: String,
) {
    val ctx = rememberPageContext()
    Column(
        CardLinkStyle.toModifier()
            .onClick {
                ctx.router.navigateTo(url)
            }
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
            H3(
                Modifier
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                LangText(
                    en = enTitle,
                    nl = nlTitle,
                )
            }
            P(
                Modifier
                    .color(SitePalette.light.onBackground.lightened(0.5f))
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