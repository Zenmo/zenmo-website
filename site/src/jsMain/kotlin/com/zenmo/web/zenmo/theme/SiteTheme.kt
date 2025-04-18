package com.zenmo.web.zenmo.theme

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.*

/**
 * @property nearBackground A useful color to apply to a container that should differentiate itself from the background
 *   but just a little.
 */
class SitePalette(
    val nearBackground: Color,
    val brand: Brand,
) {
    class Brand(
        val primary: Color = Color.rgb(0xb6084e),
        val onPrimary: Color = Color.rgb(0xFFFFFF),
        val primaryContainer: Color = Color.rgb(0xD92E65),
        val secondary: Color = Color.rgb(0x3C83EF),
        val surfaceContainerLow: Color = Color.rgb(0xFFF0F1),
        val surface: Color = Color.rgb(0xFFF8F7),
        val onBackground: Color = Color.rgb(0x26181A)
    )
}

object SitePalettes {
    val light = SitePalette(
        nearBackground = Color.rgb(0xFFF0F1),
        brand = SitePalette.Brand()
    )
}

fun ColorMode.toSitePalette(): SitePalette = SitePalettes.light

@InitSilk
fun initTheme(ctx: InitSilkContext) {
    ctx.theme.palettes.light.apply {
        background = SitePalettes.light.brand.surface
        color = SitePalettes.light.brand.onBackground
        overlay = SitePalettes.light.brand.surfaceContainerLow
        text.set(
            primary = SitePalettes.light.brand.onBackground,
            secondary = SitePalettes.light.brand.secondary
        )
        button.set(
            default = SitePalettes.light.brand.primary,
            hover = SitePalettes.light.brand.primary.darkened(byPercent = 0.1f),
            focus = SitePalettes.light.brand.primary,
            pressed = SitePalettes.light.brand.primary.darkened(byPercent = 0.2f),
        )

    }
}


/**
 * Trying to add custom text colors to the Silk theme but
 * this is not working as expected.
 * Throws an uncaught exception: NoSuchElementException
 *
 * This implementation is inspired from [com.varabyte.kobweb.silk.theme.colors.palette.tooltip]
 * */
val Palette.text: Text get() = (this as MutablePalette).text
val MutablePalette.text: MutableText
    get() = MutableText(this)

interface Text {
    val primary: Color
    val secondary: Color
}

class MutableText(palette: MutablePalette) : MutablePalette.ColorGroup(palette = palette, groupName = "text"),
    Text {
    override var primary by paletteEntry()
    override var secondary by paletteEntry()

    fun set(
        primary: Color,
        secondary: Color,
    ) {
        this.primary = primary
        this.secondary = secondary
    }
}
