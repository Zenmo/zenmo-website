package com.zenmo.web.zenmo.components.widgets.button

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.thenIf
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.theme.font.LabelLargeTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.toSitePalette
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.px

val PrimaryButtonVariant = ButtonStyle.addVariant(extraModifier = {
    TextStyle.toModifier(LabelLargeTextStyle)
}) {
    val colorPalette = colorMode.toSitePalette()
    base {
        Modifier
            .width(auto)
            .height(auto)
            .background(colorPalette.primary)
            .color(colorPalette.onPrimary)
            .padding(leftRight = 2.25.em, topBottom = 1.1.em)
    }
}

val PrimaryButtonWithIconPadding = ButtonStyle.addVariant {
    base {
        Modifier.padding(left = 2.25.em, right = 2.em, top = 1.em, bottom = 1.em)
    }
}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    enText: String? = null,
    nlText: String? = null,
    icon: (@Composable () -> Unit)? = null,
    onClick: (SyntheticMouseEvent) -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        variant = PrimaryButtonVariant.thenIf(icon != null, PrimaryButtonWithIconPadding),
    ) {
        Row(
            modifier = Modifier.gap(12.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LangText(
                en = enText,
                nl = nlText,
            )
            icon?.invoke()
        }
    }
}