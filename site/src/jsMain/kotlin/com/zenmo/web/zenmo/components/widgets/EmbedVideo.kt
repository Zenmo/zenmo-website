package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Iframe
import org.jetbrains.compose.web.dom.P

@Composable
fun EmbedVideo(
    videoScr: String,
    enTitle: String,
    nlTitle: String,
    enDescriptionParagraph: String,
    nlDescriptionParagraph: String,
    reversed: Boolean = false,
) {
    SimpleGrid(
        numColumns(base = 1, md = 2, lg = 2, xl = 2),
        modifier = Modifier.gap(2.cssRem)
    ) {
        when (reversed) {
            true -> {
                TextContent(
                    enTitle = enTitle,
                    nlTitle = nlTitle,
                    enDescriptionParagraph = enDescriptionParagraph,
                    nlDescriptionParagraph = nlDescriptionParagraph
                )
                VideoContent(videoScr)
            }

            false -> {
                VideoContent(videoScr)
                TextContent(
                    enTitle = enTitle,
                    nlTitle = nlTitle,
                    enDescriptionParagraph = enDescriptionParagraph,
                    nlDescriptionParagraph = nlDescriptionParagraph
                )
            }
        }
    }
}


@Composable
private fun TextContent(
    enTitle: String,
    nlTitle: String,
    enDescriptionParagraph: String,
    nlDescriptionParagraph: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .gap(1.cssRem),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        SubHeaderText(
            enText = enTitle,
            nlText = nlTitle,
            modifier = Modifier.fontWeight(FontWeight.Bold)
                .margin(0.cssRem)
        )
        P(
            Modifier.color(
                SitePalette.light.onBackground.lightened(0.5f)
            ).toAttrs()
        ) {
            LangText(
                en = enDescriptionParagraph,
                nl = nlDescriptionParagraph,
            )
        }
    }
}


val VideoContentStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .borderRadius(4.px)
            .overflow(Overflow.Hidden)
    }

    Breakpoint.ZERO {
        Modifier.height(284.px)
    }
    Breakpoint.SM {
        Modifier
            .height(284.px)
    }
    Breakpoint.MD {
        Modifier
            .height(272.px)
    }
    Breakpoint.LG {
        Modifier
            .height(328.px)
    }
    Breakpoint.XL {
        Modifier
            .height(328.px)
    }
}


@Composable
private fun VideoContent(
    videoScr: String,
) {
    Div(
        VideoContentStyle.toModifier().toAttrs()
    ) {
        Iframe(
            attrs = {
                attr("src", videoScr)
                attr(
                    "allow",
                    "accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture;web-share"
                )
                attr("allowFullScreen", "true")
                attr("frameBorder", "0")
                attr("referrerPolicy", "strict-origin-when-cross-origin")
                attr("loading", "lazy")
                attr("width", "100%")
                attr("height", "100%")
            }
        )
    }
}