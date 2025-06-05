package com.zenmo.web.zenmo.domains.zenmo.pages.aboutUs

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.components.layouts.PageLayout
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.components.widgets.SectionContainerStyle
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.home.LuxProductsTextHeaderStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.team.TeamCard
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam
import com.zenmo.web.zenmo.theme.toSitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent


val OurTeamContainerVariant = SectionContainerStyle.addVariant {
    base {
        Modifier
            .backgroundColor(colorMode.toSitePalette().surfaceContainerLow)
    }
}

@Composable
fun OurTeamPage() {
    PageLayout("Our Team") {
        SectionContainer {
            Column(
                modifier = LuxProductsTextHeaderStyle.toModifier().fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubHeaderText(
                    enText = "Our Team",
                    nlText = "Onze Team",
                    modifier = Modifier.margin(bottom = 0.5.cssRem)
                )
                HeaderText(
                    enText = "Meet the lovely people behind Zenmo",
                    nlText = "Ontmoet de geweldige mensen achter Zenmo",
                    modifier = Modifier
                        .width(50.percent)
                        .textAlign(TextAlign.Center)
                        .margin(0.cssRem),
                )
            }
            TeamMembers()
        }
    }
}


@Composable
private fun TeamMembers() {
    SimpleGrid(
        numColumns(base = 1, sm = 2, md = 3, lg = 3, xl = 3),
        modifier = Modifier.gap(1.cssRem).fillMaxWidth().margin(bottom = 5.cssRem),
    ) {
        ZenmoTeam.forEach { TeamCard(it) }
    }
}