package com.zenmo.web.zenmo.domains.zenmo.widgets.button

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.shifted
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto


@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        variant = IconButtonVariant
    ) {
        content()
    }
}


val IconButtonVariant = ButtonStyle.addVariant {
    base {
        Modifier
            .width(auto)
            .height(auto)
            .alignContent(AlignContent.Center)
            .justifyContent(JustifyContent.Center)
            .display(DisplayStyle.Flex)
            .padding(0.5.cssRem)
            .borderRadius(50.percent)
    }
    hover {
        Modifier.background(SitePalette.light.primary)
            .color(SitePalette.light.onPrimary)
    }
    active {
        Modifier.background(SitePalette.light.primary.shifted(colorMode, 0.2f))
    }
}