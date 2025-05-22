package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.init.InitKobwebContext
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.sections.component_demo.AnyLogicDemo
import com.zenmo.web.zenmo.components.sections.component_demo.PageHeadingsDemo
import com.zenmo.web.zenmo.components.sections.component_demo.SubHeadingsDemo
import com.zenmo.web.zenmo.components.sections.component_demo.TextParagraphsDemo
import com.zenmo.web.zenmo.pages.SiteGlobals
import com.zenmo.web.zenmo.theme.font.DisplayTextStyle
import com.zenmo.web.zenmo.theme.font.TextStyle
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Span

val DemoPageContainerVariant = SectionContainerStyle.addVariant {
    base {
        Modifier
            .fillMaxWidth()
            .margin(topBottom = 2.cssRem)
            .padding(leftRight = 4.cssRem)
    }

    Breakpoint.MD {
        Modifier
            .width(90.percent)
    }
    Breakpoint.LG {
        Modifier
            .width(75.percent)
    }

    Breakpoint.XL {
        Modifier
            .width(75.percent)
    }
}


/**
 * Page to demo the usage of components
 */
@Page
@Composable
fun ComponentDemoPage() {
    SectionContainer {
        Span(
            TextStyle.toModifier(DisplayTextStyle)
                .padding(top = 2.cssRem)
                .toAttrs()
        ) {
            LangText(
                en = "Demo of Components",
                nl = "Demo van Componenten",
            )
        }
        SectionContainer(
            modifier = Modifier
                .margin(topBottom = 2.cssRem)
                .padding(leftRight = 4.cssRem),
            variant = DemoPageContainerVariant,
            verticalArrangement = Arrangement.spacedBy(4.cssRem)
        ) {
            PageHeadingsDemo()
            SubHeadingsDemo()
            CustomizationNotes(
                enCustomizationNotes = """
                    To give the text a color other than default, chain the `color` modifier before the `toAttrs()` call.
                    Like this: .color(SitePalette.light.primary).toAttrs(). 
                    SitePalette contains custom color palette defined for the site's theme.
                """.trimIndent(),
                nlCustomizationNotes = """
                    Om de tekst een andere kleur dan standaard te geven, keten je de `color`-modifier voor de `toAttrs()`-aanroep.
                    Zoals dit: .color(SitePalette.light.primary).toAttrs().
                    SitePalette bevat een aangepast kleurenpalet dat is gedefinieerd voor het thema van de site.
                """.trimIndent(),
            )
            TextParagraphsDemo()
            AnyLogicDemo()
        }
    }
}


fun devComponentDemoRouter(ctx: InitKobwebContext) {
    //TODO: allow for remote dev domain and test domain maybe?
    if (window.location.host == SiteGlobals.LOCAL_DEV_ENV) {
        ctx.router.register("/component-demo") { ComponentDemoPage() }
    }
}