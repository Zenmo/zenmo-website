package com.zenmo.web.zenmo.domains.lux.subdomains.genius

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.mdi.MdiMail
import com.varabyte.kobweb.silk.components.icons.mdi.MdiPhone
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.components.widgets.MediaContentLayout
import com.zenmo.web.zenmo.components.widgets.SectionContainer
import com.zenmo.web.zenmo.domains.lux.widgets.headings.HeaderText
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import com.zenmo.web.zenmo.domains.zenmo.sections.team.TeamCardImageContainerStyle
import com.zenmo.web.zenmo.domains.zenmo.sections.team.TeamMember
import com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic.AnyLogicEmbed
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import kotlin.uuid.Uuid


@Composable
fun GeniusIndex() {
    Column(Modifier.fillMaxSize()) {
        SectionContainer(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .background(SitePalette.light.primary)
                .color(SitePalette.light.onPrimary)
        ) {
            HeaderText(
                enText = "Genius",
                nlText = "Genius",
                modifier = Modifier.margin(2.cssRem, 0.cssRem, 0.cssRem, 1.cssRem)
            )
            Span(
                Modifier.margin(0.cssRem, 0.cssRem, 2.cssRem, 1.cssRem).toAttrs()
            ) {
                LangText(
                    en = "Design your own energy system",
                    nl = "Ontwerp je eigen energiesysteem",
                )
            }
        }

        SectionContainer(
            modifier = Modifier.margin(bottom = 3.cssRem),
        ) {
            AnyLogicEmbed(
                modelId = Uuid.parse("c31871aa-a043-49e6-8d91-fef9b2fc4643"), //todo replace with actual model ID for Genius
                apiKey = Uuid.parse("17e0722f-25c4-4549-85c3-d36509f5c710"),
                modifier = Modifier.maxWidth(90.cssRem).margin(topBottom = 2.cssRem)
            )

            MediaContentLayout(
                imageUrl = "",
                visualContent = {
                    Box(TeamCardImageContainerStyle.toModifier().size(22.cssRem)) {
                        Image(
                            modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover).clip(Circle()),
                            src = TeamMember.ATE.image,
                            alt = "${TeamMember.ATE.name} photo",
                        )
                    }
                },
                title = {
                    HeaderText(
                        enText = TeamMember.ATE.name,
                        nlText = TeamMember.ATE.name,
                        modifier = Modifier.margin(0.cssRem)
                    )
                },
                subtitle = {
                    SubHeaderText(
                        enText = "Website and model development",
                        nlText = "Website en model ontwikkeling",
                        modifier = Modifier.color(SitePalette.light.primary)
                            .margin(0.cssRem)
                    )
                },
                description = {
                    Column(Modifier.gap(0.5.cssRem)) {
                        Row {
                            MdiPhone(Modifier.padding(right = 0.25.cssRem))
                            Text("+31 6 14910380")
                        }

                        Row {
                            MdiMail(Modifier.padding(right = 0.25.cssRem))
                            Text(TeamMember.ATE.email)
                        }
                    }
                },
                actionText = {},
                reversed = false,
            )
        }
    }
}
