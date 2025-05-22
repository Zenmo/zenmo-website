package com.zenmo.web.zenmo.domains.zenmo.sections.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.zenmo.sections.home.components.LuxProductCard
import com.zenmo.web.zenmo.domains.zenmo.sections.home.components.LuxProducts
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.PrimaryButton
import com.zenmo.web.zenmo.theme.font.*
import com.zenmo.web.zenmo.theme.styles.OutlinePrimaryButtonStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span

const val LUX_OVERVIEW_SECTION_ID = "lux-overview"

val LuxProductsGridStyle = CssStyle {
    Breakpoint.XL {
        Modifier
            .width(85.percent)
    }
}

@Composable
fun LuxInfoSection() {
    val breakpoint = rememberBreakpoint()
    SectionContainer(
        modifier = Modifier.id(LUX_OVERVIEW_SECTION_ID),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextContent(breakpoint)
        Column(
            modifier = LuxProductsGridStyle.toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LuxProductsTextHeader()
            LuxProductCards()
        }
    }
}

@Composable
private fun LuxProductCards() {
    SimpleGrid(
        numColumns(base = 1, md = 2, lg = 2, xl = 2),
        modifier = Modifier.gap(1.cssRem).fillMaxWidth().margin(bottom = 5.cssRem),
    ) {
        LuxProducts.forEach {
            LuxProductCard(
                luxProduct = it,
                modifier = Modifier.cursor(Cursor.Pointer)
                    .onClick {
                        /*todo navigate/redirect to LUX product details page accordingly*/
                    }
            )
        }
    }
}

val AnchorLinkStyle = CssStyle(
    extraModifier = {
        TextStyle.toModifier(
            DisplayTextStyle, TextStylePrimaryColor,
        )
    }
) {
    base {
        Modifier
            .textDecorationLine(TextDecorationLine.None)
            .cursor(Cursor.Default)
    }
}

@Composable
private fun TextContent(
    breakpoint: Breakpoint,
) {
    Column(
        modifier = Modifier.margin(top = 8.5.cssRem),
        verticalArrangement = Arrangement.spacedBy(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        A(
            attrs = AnchorLinkStyle.toAttrs(),
            href = "#$LUX_OVERVIEW_SECTION_ID"
        ) {
            LangText(
                en = "LUX Overview",
                nl = "LUX Overzicht",
            )
        }
        P(
            TextStyle.toModifier(BodyLargeTextStyle, TextStyleSecondaryColor)
                .maxWidth(if (breakpoint >= Breakpoint.SM) 80.percent else 100.percent)
                .textAlign(TextAlign.Center)
                .toAttrs(),
        ) {
            LangText(
                en =
                    """
                        LUX provides companies and areas with quick and effective insight into solutions for grid 
                        congestion using, among other things, batteries. LUX is open source software originally developed 
                        by Zenmo and TU Eindhoven and is also a further development of the HOLON project.
                        """.trimIndent(),
                nl =
                    """
                        LUX biedt bedrijven en gebieden snel en effectief inzicht in oplossingen voor netcongestie met 
                        behulp van ondermeer batterijen. LUX is open source software die oorspronkelijk is ontwikkeld door 
                        Zenmo en de TU Eindhoven en die tevens een doorontwikkeling is vanuit het HOLON project.
                        """.trimIndent(),
            )
        }
        PrimaryButton(
            modifier = OutlinePrimaryButtonStyle.toModifier(),
            enText = "Find out more",
            nlText = "Meer informatie",
            onClick = {
                /*todo redirect to LUX.com*/
            }
        )
    }
}

val LuxProductsTextHeaderStyle = CssStyle {
    base {
        Modifier
            .margin(top = 8.5.cssRem, bottom = 5.cssRem)
            .fillMaxWidth()
    }

    Breakpoint.ZERO {
        Modifier
            .margin(top = 3.cssRem, bottom = 1.5.cssRem)
    }

    Breakpoint.SM {
        Modifier
            .margin(top = 6.cssRem, bottom = 3.cssRem)
    }

    Breakpoint.MD {
        Modifier
            .margin(top = 7.cssRem, bottom = 3.5.cssRem)
    }
}


@Composable
private fun LuxProductsTextHeader() {
    Column(
        modifier = LuxProductsTextHeaderStyle.toModifier(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Span(
            attrs = TextStyle.toModifier(
                TitleTextStyle, TextStylePrimaryColor
            ).margin(bottom = 0.5.cssRem)
                .toAttrs()
        ) {
            LangText(
                en = "Explore",
                nl = "Verken",
            )
        }
        Span(
            attrs = TextStyle.toModifier(
                DisplayTextStyle, TextStylePrimaryColor
            ).toAttrs()
        ) {
            LangText(
                en = "LUX Products",
                nl = "LUX Producten",
            )
        }
    }
}