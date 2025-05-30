package com.zenmo.web.zenmo.theme

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.button
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.zenmo.web.zenmo.pages.SiteGlobals
import kotlinx.browser.window


data class LuxSpecificColorHues(
    val luxBlue: Color = Color.rgb(0x3C83EF),
    val luxRed: Color = Color.rgb(0xF8285A),
    val luxYellow: Color = Color.rgb(0xFFC300),
    val luxGreen: Color = Color.rgb(0x28A745),
)

data class SitePalette(
    val primary: Color = Color.rgb(0xb6084e),
    val onPrimary: Color = Color.rgb(0xFFFFFF),
    val primaryContainer: Color = Color.rgb(0xD92E65),
    val secondary: Color = Color.rgb(0x3d2c2f),
    val surfaceContainerLow: Color = Color.rgb(0xFFF0F1),
    val surface: Color = Color.rgb(0xFFF8F7),
    val onBackground: Color = Color.rgb(0x26181A),

    // Lux data visualization Colors for map legends and charts.
    val luxDataVizColors: List<Color> = emptyList(),
    val luxSpecificColorHues: LuxSpecificColorHues = LuxSpecificColorHues()

    /** TODO: Standardized Colors for Specific Concepts/Purposes
     *    like electricity, gasoline, etc.
     *
     *   val electricity: Color,
     *   val gasoline: Color,
     */
) {
    companion object {
        private val zenmoColorPalette = SitePalette()

        private val luxColorPalette = SitePalette(
            primary = Color.rgb(0x004548), // dark teal
            onPrimary = Color.rgb(0xFFFFFF),
            primaryContainer = Color.rgb(0xd7e2ff),
            secondary = Color.rgb(0xffc300), // orange-ish yellow
            surfaceContainerLow = Color.rgb(0xf2f4f4),
            surface = Color.rgb(0xf7faf9),
            onBackground = Color.rgb(0x2d3131),

            /** generated these with https://material-foundation.github.io/material-theme-builder/
             * using the Lux color palette as a base
             */
            luxDataVizColors = listOf(
                Color.rgb(0xFFC300), // orange-ish yellow like secondary
                Color.rgb(0x007E84),  // teal, not dark teal
                Color.rgb(0x8bd2d7), // light teal, an inverse of the teal
                Color.rgb(0xffe5b2), // medium contrast of the orange-yellow
                Color.rgb(0x3C83EF), // blue
                Color.rgb(0xF8285A), // red
            ),

            luxSpecificColorHues = LuxSpecificColorHues()
        )
        val light = when (window.location.host) {
            SiteGlobals.ZENMO_DOMAIN -> zenmoColorPalette
            else -> luxColorPalette
        }
    }
}


fun ColorMode.toSitePalette(): SitePalette = SitePalette.light

@InitSilk
fun initTheme(ctx: InitSilkContext) {
    ctx.theme.palettes.light.apply {
        background = SitePalette.light.surface
        color = SitePalette.light.onBackground
        overlay = SitePalette.light.surfaceContainerLow
        button.set(
            default = SitePalette.light.primary,
            hover = SitePalette.light.primary.darkened(byPercent = 0.1f),
            focus = SitePalette.light.primary,
            pressed = SitePalette.light.primary.darkened(byPercent = 0.2f),
        )
    }
}
