package com.zenmo.web.zenmo.theme

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.button
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.overlay

data class SitePalette(
    val primary: Color = Color.rgb(0xb6084e),
    val onPrimary: Color = Color.rgb(0xFFFFFF),
    val primaryContainer: Color = Color.rgb(0xD92E65),
    val secondary: Color = Color.rgb(0x3d2c2f),
    val surfaceContainerLow: Color = Color.rgb(0xFFF0F1),
    val surface: Color = Color.rgb(0xFFF8F7),
    val onBackground: Color = Color.rgb(0x26181A)
) {
    companion object {
        val light = SitePalette()
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
