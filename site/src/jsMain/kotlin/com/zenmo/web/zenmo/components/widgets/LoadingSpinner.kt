package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.toModifier
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

val SpinKeyframes = Keyframes {
    from {
        Modifier.transform {
            rotate(0.deg)
        }
    }

    to {
        Modifier.transform {
            rotate(360.deg)
        }
    }
}

val SpinnerStyle = CssStyle {
    base {
        Modifier
            .width(30.px)
            .height(30.px)
            .border(3.px, LineStyle.Solid, Color.lightgray)
            .borderRadius(50.percent)
            .borderTop(3.px, LineStyle.Solid, SitePalette.light.primary)
            .animation(
                SpinKeyframes
                    .toAnimation(
                        duration = 1.s,
                        timingFunction = AnimationTimingFunction.Linear,
                        iterationCount = AnimationIterationCount.Infinite,
                    )
            )
    }
}

@Composable
fun LoadingSpinner() {
    Div(
        attrs = SpinnerStyle.toModifier().toAttrs()
    )
}