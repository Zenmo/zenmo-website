package com.zenmo.web.zenmo.domains.zenmo.sections.team

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.mdi.MdiMail
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.IconButton
import com.zenmo.web.zenmo.theme.SitePalette
import com.zenmo.web.zenmo.theme.font.*
import com.zenmo.web.zenmo.theme.styles.IconStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text


val TeamCardImageContainerStyle = CssStyle {
    base {
        Modifier
            .size(15.cssRem)
            .borderRadius(
                50.percent
            )
            .border(
                width = 10.px,
                color = Color.white,
                style = LineStyle.Solid
            )
    }

    Breakpoint.XL {
        Modifier
            .size(20.cssRem)
    }

    Breakpoint.LG {
        Modifier
            .size(20.cssRem)
    }
}


@Composable
fun TeamCard(
    teamMember: TeamMember,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.px).margin(bottom = 0.5.cssRem)
    ) {
        Box(TeamCardImageContainerStyle.toModifier()) {
            Image(
                modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover).clip(Circle()),
                src = "/${teamMember.image}",
                alt = "${teamMember.name} photo",
            )
        }
        H3(
            TextStyle.toModifier(
                TitleTextStyle, TextStyleBrandColor
            )
                .fontWeight(FontWeight.Bold)
                .margin(top = 1.5.cssRem, bottom = 0.5.cssRem)
                .toAttrs()
        ) {
            Text(teamMember.name)
        }
        Span(
            TextStyle.toModifier(
                BodyLargeTextStyle, TextStylePrimaryColor
            )
                .textAlign(TextAlign.Center)
                .toAttrs()
        ) {
            LangText(
                en = teamMember.enTitle,
                nl = teamMember.nlTitle,
            )
        }
//        P(
//            attrs = Modifier
//                .textAlign(TextAlign.Center)
//                .margin(0.cssRem)
//                .toAttrs()
//        ) {
//            LangText(
//                en = teamMember.enShortBio,
//                nl = teamMember.nlShortBio,
//            )
//        }
        Spacer()
        TeamMemberSocials(
            email = teamMember.email,
            linkedin = teamMember.linkedIn,
            twitter = teamMember.twitter,
        )
    }
}

const val X_SVG = "/img/x.svg"
const val LINKEDIN_SVG = "/img/linkedin.svg"

@Composable
private fun TeamMemberSocials(
    email: String,
    linkedin: String,
    twitter: String? = null,
) {
    Row(
        modifier = Modifier.margin(top = 1.5.cssRem),
        horizontalArrangement = Arrangement.spacedBy(0.7.cssRem),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        IconButton(
            modifier = Modifier.background(SitePalette.light.onBackground),
            onClick = {

            }) {
            MdiMail()
        }

        IconButton(
            modifier = Modifier
                .background(SitePalette.light.onBackground),
            onClick = {
                // open linkedin link
            }) {
            Image(
                modifier = IconStyle.toModifier(),
                src = LINKEDIN_SVG
            )
        }

        twitter?.let {
            IconButton(
                modifier = Modifier
                    .background(SitePalette.light.onBackground),
                onClick = {
                    // open twitter link
                }) {
                Image(
                    modifier = IconStyle.toModifier(),
                    src = X_SVG
                )
            }
        }
    }

}