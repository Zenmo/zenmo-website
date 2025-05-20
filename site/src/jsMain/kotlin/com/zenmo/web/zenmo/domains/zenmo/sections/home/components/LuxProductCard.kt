package com.zenmo.web.zenmo.domains.zenmo.sections.home.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowRightAlt
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.colors.shifted
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.BodyLargeTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.font.TextStyleSecondaryColor
import com.zenmo.web.zenmo.theme.font.TitleTextStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


val ProductCardStyle = CssStyle(
    extraModifier = {
        TextStyle.toModifier(BodyLargeTextStyle)
    }
) {
    val colors = colorMode.toPalette()
    base {
        Modifier
            .borderRadius(30.px)
            .backgroundColor(Colors.Transparent)
            .transition(
                Transition.of(property = "background", duration = 100.ms),
            )
    }
    hover {
        Modifier
            .backgroundColor(colors.overlay.shifted(colorMode, 0.1f))
    }

    cssRule("> div > .arrowForward") {
        Modifier
            .padding(left = 0.15.cssRem)
    }

    cssRule(":hover > div > .arrowForward") {
        Modifier
            .padding(left = 0.55.cssRem)
            .transition(
                Transition.of(property = "padding", duration = 100.ms),
            )
    }
}


@Composable
fun LuxProductCard(
    modifier: Modifier = Modifier,
    luxProduct: LuxProduct
) {
    Column(
        modifier = ProductCardStyle.toModifier()
            .margin(all = 0.5.cssRem)
            .padding(all = 2.5.cssRem)
            .then(modifier),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(1.5.em)
    ) {
        /*todo: we could replace this product logo or some related relevant visual*/
        ProductMonogram(
            modifier = Modifier
                .size(3.5.em),
            title = luxProduct.productTitle
        )

        Div(
            TextStyle.toModifier(TitleTextStyle, TextStyleSecondaryColor)
                .fontWeight(FontWeight.Bold)
                .toAttrs()
        ) {
            Text(luxProduct.productTitle)
            MdiArrowRightAlt(
                modifier = Modifier
                    .classNames("arrowForward")
                    .display(DisplayStyle.InlineBlock)
            )
        }

        P(
            attrs =
                TextStyle.toModifier(BodyLargeTextStyle, TextStyleSecondaryColor)
                    .margin(bottom = 0.6.cssRem)
                    .toAttrs(),
        ) {
            LangText(
                en = luxProduct.enDescription,
                nl = luxProduct.nlDescription,
            )
        }
    }
}


val ProductMonogramStyle = CssStyle {
    base {
        Modifier
            .borderRadius(50.percent)
            .backgroundColor(SitePalette.light.primary)
            .padding(0.5.cssRem)
    }
}

@Composable
private fun ProductMonogram(
    modifier: Modifier = Modifier,
    title: String,
) {

    Box(
        modifier = ProductMonogramStyle.toModifier()
            .then(modifier),
        contentAlignment = Alignment.Center,
    ) {
        SpanText(
            text = title.extractInitials(),
            modifier = TextStyle.toModifier(TitleTextStyle, TextStyleSecondaryColor)
                .fontWeight(FontWeight.Bold)
                .color(SitePalette.light.onPrimary)
        )
    }
}

fun String.extractInitials(maxInitials: Int = 2): String {
    if (isBlank()) return ""

    val words = split(" ").filter { it.isNotBlank() }
    return words
        .take(maxInitials)
        .joinToString("") { word ->
            word.firstOrNull()?.uppercase() ?: ""
        }
}
