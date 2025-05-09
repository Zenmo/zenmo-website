package com.zenmo.web.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.icons.mdi.MdiArrowRightAlt
import com.varabyte.kobweb.silk.components.icons.mdi.MdiTipsAndUpdates
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.colors.shifted
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.components.sections.home.LUX_OVERVIEW_SECTION_ID
import com.zenmo.web.zenmo.components.sections.home.LuxInfoSection
import com.zenmo.web.zenmo.components.sections.home.components.styles.ExtraContentDividerStyle
import com.zenmo.web.zenmo.components.sections.home.components.styles.HomePageContainerVariant
import com.zenmo.web.zenmo.components.sections.home.components.styles.HomePageSectionGridStyle
import com.zenmo.web.zenmo.components.sections.home.components.styles.HomePageVisualStyle
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.components.widgets.button.PrimaryButton
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.BodyLargeTextStyle
import com.zenmo.web.zenmo.theme.font.HolonBlockHeaderTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import com.zenmo.web.zenmo.theme.font.TextStyleSecondaryColor
import com.zenmo.web.zenmo.theme.styles.IconStyle
import kotlinx.browser.document
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val HeroContainerStyle = CssStyle {
    base { Modifier.fillMaxWidth().gap(2.cssRem) }
    Breakpoint.MD { Modifier.margin { top(20.vh) } }
}


@Page
@Composable
fun HomePage() {
    PageLayout("Home") {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val breakpoint = rememberBreakpoint()
            SectionContainer(
                modifier = Modifier.gap(0.5.cssRem),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                variant = HomePageContainerVariant
            ) {
                Div(attrs = HomePageSectionGridStyle.toAttrs()) {
                    AboutZenmoTextContent(
                        breakpoint = breakpoint,
                    )
                    VisualContent()
                }
            }
            ExtraZenmoTextContent(breakpoint)
            LuxInfoSection()
        }
    }
}


@Composable
private fun AboutZenmoTextContent(
    breakpoint: Breakpoint,
) {
    Column(
        modifier = Modifier
            .flex(1),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = if (breakpoint >= Breakpoint.LG) Alignment.Start else Alignment.CenterHorizontally
    ) {
        Div(
            TextStyle.toModifier(HolonBlockHeaderTextStyle)
                .textAlign(if (breakpoint > Breakpoint.MD) TextAlign.Start else TextAlign.Center)
                .maxWidth(if (breakpoint >= Breakpoint.SM) 80.percent else 100.percent)
                .toAttrs()
        ) {
            LangText(
                nl = "Wij zijn Zenmo simulations",
                en = "We are Zenmo simulations",
            )
        }
        Div(
            TextStyle.toModifier(BodyLargeTextStyle, TextStyleSecondaryColor)
                .margin(top = 1.cssRem, right = 1.cssRem)
                .textAlign(if (breakpoint > Breakpoint.MD) TextAlign.Start else TextAlign.Center)
                .toAttrs(),
        ) {
            LangText(
                nl =
                    """
                        Zenmo is een verbindende schakel tussen bedrijven, netbeheerders, overheden en kennisinstellingen. 
                        Onze missie is het kosteneffectief versnellen van de transitie van fossiele naar duurzame energie 
                        met een focus op slimme decentrale bottom-up oplossingen voor netcongestie met ondermeer batterijen.
                        """.trimIndent(),
                en =
                    """
                        Zenmo is a connecting link between companies, grid operators, governments and knowledge institutions. 
                        Our mission is to cost-effectively accelerate the transition from fossil to sustainable energy 
                        with a focus on smart decentralized bottom-up solutions for grid congestion, including batteries.
                        """.trimIndent(),
            )
        }
        PrimaryButton(
            modifier = Modifier.margin(top = 2.cssRem),
            enText = "We are the creators of LUX energy twin",
            nlText = "Wij zijn de makers van LUX energy twin",
            icon = {
                MdiArrowRightAlt()
            },
            onClick = {
                val element = document.getElementById(LUX_OVERVIEW_SECTION_ID)
                element?.scrollIntoView()
            }
        )
    }
}

@Composable
private fun VisualContent() {
    val colorPalette = ColorMode.current.toPalette()
    Box(
        modifier = HomePageVisualStyle.toModifier()
            .flex(1)
            //todo remove height & background when the image is ready
            .minHeight(350.px)
            .backgroundColor(colorPalette.overlay.shifted(ColorMode.current, 0.1f))
            .borderRadius(30.px),
        contentAlignment = Alignment.Center
    ) {
        Text("placeholder for visual content")
    }
}

@Composable
private fun ExtraZenmoTextContent(
    breakpoint: Breakpoint
) {
    Box(
        modifier = ExtraContentDividerStyle.toModifier(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier.displayIfAtLeast(Breakpoint.LG).padding(right = 1.cssRem),
                contentAlignment = Alignment.Center
            ) {
                MdiTipsAndUpdates(
                    IconStyle.toModifier()
                        .color(SitePalette.light.primary)
                )
            }
            P(
                attrs = TextStyle.toModifier(BodyLargeTextStyle, TextStyleSecondaryColor)
                    .maxWidth(if (breakpoint >= Breakpoint.SM) 75.percent else 100.percent)
                    .textAlign(TextAlign.Center)
                    .toAttrs()
            ) {
                LangText(
                    nl = "Zenmo maakt simulatiemodellen met een visuele interface, waarmee je zelf de effecten van verschillende verduurzamingsscenario's in jouw gebied kan bekijken.",
                    en = "Zenmo creates simulation models with a visual interface, allowing you to view the effects of different sustainability scenarios in your area."
                )
            }
        }
    }
}