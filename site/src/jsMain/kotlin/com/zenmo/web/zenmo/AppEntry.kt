package com.zenmo.web.zenmo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.saveToLocalStorage
import com.zenmo.web.zenmo.core.services.localization.LocalLanguage
import com.zenmo.web.zenmo.core.services.localization.defaultLanguageLocal
import org.jetbrains.compose.web.css.vh

private const val COLOR_MODE_KEY = "zenmo:colorMode"

@InitSilk
fun initColorMode(ctx: InitSilkContext) {
    ctx.config.initialColorMode = ColorMode.LIGHT
}

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    SilkApp {
        val colorMode = ColorMode.current
        LaunchedEffect(colorMode) {
            colorMode.saveToLocalStorage(COLOR_MODE_KEY)
        }

        Surface(
            SmoothColorStyle.toModifier()
                .minHeight(100.vh)
                .scrollBehavior(ScrollBehavior.Smooth)
        ) {
            CompositionLocalProvider(LocalLanguage provides defaultLanguageLocal) {
                content()
            }
        }
    }
}