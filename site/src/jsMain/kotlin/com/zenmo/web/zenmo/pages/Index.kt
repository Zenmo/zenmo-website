package com.zenmo.web.zenmo.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page

import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.zenmo.web.zenmo.HeadlineTextStyle
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.toSitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.css.*
import org.w3c.dom.Text

// Container that has a tagline and grid on desktop, and just the tagline on mobile
val HeroContainerStyle = CssStyle {
    base { Modifier.fillMaxWidth().gap(2.cssRem) }
    Breakpoint.MD { Modifier.margin { top(20.vh) } }
}

// A demo grid that appears on the homepage because it looks good
val HomeGridStyle = CssStyle.base {
    Modifier
        .gap(0.5.cssRem)
        .width(70.cssRem)
        .height(18.cssRem)
}

private val GridCellColorVar by StyleVariable<Color>()
val HomeGridCellStyle = CssStyle.base {
    Modifier
        .backgroundColor(GridCellColorVar.value())
        .boxShadow(blurRadius = 0.6.cssRem, color = GridCellColorVar.value())
        .borderRadius(1.cssRem)
}

@Composable
private fun GridCell(color: Color, row: Int, column: Int, width: Int? = null, height: Int? = null) {
    Div(
        HomeGridCellStyle.toModifier()
            .setVariable(GridCellColorVar, color)
            .gridItem(row, column, width, height)
            .toAttrs()
    )
}

@Page
@Composable
fun HomePage() {
    PageLayout("Home") {
        val sitePalette = ColorMode.current.toSitePalette()
        Column(
            modifier = HeroContainerStyle.toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Div(HeadlineTextStyle.toAttrs()) {
                SpanText("Wij zijn Zenmo simulations")
            }
            Div {
                P(attrs = {}) {Text("Just Text")}

                SpanText("Zenmo maakt simulatiemodellen met een visuele interface, waarmee je zelf de effecten van verschillende verduurzamingsscenario's in jouw gebied kan bekijken.")
                SpanText("Zenmo is een verbindende schakel tussen bedrijven, netbeheerders, overheden en kennisinstellingen. Onze missie is het kosteneffectief versnellen van de transitie van fossiele naar duurzame energie met een focus op slimme decentrale bottom-up oplossingen voor netcongestie met ondermeer batterijen.")
                SpanText("[Logo HOLON => logo LUX]Wij zijn de makers van LUX energy twin.")
                SpanText("LUX biedt bedrijven en gebieden snel en effectief inzicht in oplossingen voor netcongestie met behulp van ondermeer batterijen. LUX is open source software die oorspronkelijk is ontwikkeld door Zenmo en de TU Eindhoven en die tevens een doorontwikkeling is vanuit het HOLON project.[link]")
            }
        }
    }
}
