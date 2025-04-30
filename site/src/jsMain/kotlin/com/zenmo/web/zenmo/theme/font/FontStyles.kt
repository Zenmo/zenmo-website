package com.zenmo.web.zenmo.theme.font

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.font
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.utils.PublicRes

sealed interface TextComponentKind : ComponentKind

val TextStyle = CssStyle<TextComponentKind> {
    val defaultFonts = Fonts[Breakpoint.LG]
    base {
        Modifier.font { defaultFonts.bodyLarge }
    }
}

val TextStylePrimaryColor = TextStyle.addVariant {
    base {
        Modifier.color(SitePalette.light.onBackground)
    }
}

val TextStyleSecondaryColor = TextStyle.addVariant {
    base {
        Modifier.color(SitePalette.light.secondary)
    }
}

val TextStyleBrandColor = TextStyle.addVariant {
    base {
        Modifier.color(SitePalette.light.primary)
    }
}


val DisplayTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.display) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.display) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.display) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.display) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.display) }
    }
}


val BodyLargeTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.bodyLarge) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.bodyLarge) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.bodyLarge) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.bodyLarge) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.bodyLarge) }
    }
}


val LabelLargeTextStyle = TextStyle.addVariant {
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.labelLarge) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.labelLarge) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.labelLarge) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.labelLarge) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.labelLarge) }
    }
}

val HolonBlockHeaderTextStyle = TextStyle.addVariant {
    fun applyHolonBlockFont(breakpoint: Breakpoint): Modifier {
        val fonts = Fonts[breakpoint]
        return Modifier.font { siteFont(fonts.display.copy(fontFamily = PublicRes.FontFamilies.HOLON_BLOCK)) }
    }

    Breakpoint.ZERO { applyHolonBlockFont(Breakpoint.ZERO) }
    Breakpoint.SM { applyHolonBlockFont(Breakpoint.SM) }
    Breakpoint.MD { applyHolonBlockFont(Breakpoint.MD) }
    Breakpoint.LG { applyHolonBlockFont(Breakpoint.LG) }
    Breakpoint.XL { applyHolonBlockFont(Breakpoint.XL) }
}


/*todo add style variants for
*  1.TitleTextStyle
*  2. LabelMediumTextStyle
*  3. BodyMediumTextStyle & BodySmall maybe  */