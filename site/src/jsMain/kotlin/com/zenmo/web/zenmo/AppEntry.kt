package com.zenmo.web.zenmo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.core.AppGlobals
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.saveToLocalStorage
import com.zenmo.web.zenmo.core.services.localization.LanguageManager
import com.zenmo.web.zenmo.core.services.localization.LocalLanguage
import kotlinx.browser.window
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

private const val COLOR_MODE_KEY = "zenmo:colorMode"

@InitSilk
fun initColorMode(ctx: InitSilkContext) {
    ctx.config.initialColorMode = ColorMode.LIGHT
}

object SiteGlobals {
    val ZENMO_DEV_DOMAIN: String = AppGlobals.getValue("ZENMO_DEV_DOMAIN")
    val LUX_DEV_DOMAIN: String = AppGlobals.getValue("LUX_DEV_DOMAIN")
    val ZENMO_TEST_DOMAIN: String = AppGlobals.getValue("ZENMO_TEST_DOMAIN")
    val LUX_TEST_DOMAIN: String = AppGlobals.getValue("LUX_TEST_DOMAIN")
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
            CompositionLocalProvider(LocalLanguage provides LanguageManager.language.value) {
                when (val domain = window.location.host) {
                    SiteGlobals.ZENMO_DEV_DOMAIN -> content()
                    else ->
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) { H1 { Text(domain.uppercase()) } }
                }
            }
        }
    }
}