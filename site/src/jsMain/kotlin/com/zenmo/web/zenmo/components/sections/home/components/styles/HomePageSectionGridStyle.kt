package com.zenmo.web.zenmo.components.sections.home.components.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.zenmo.web.zenmo.theme.SitePalette
import org.jetbrains.compose.web.css.*

val HomePageSectionGridStyle = CssStyle {
    /*todo add a extra-modifier opacity animation maybe*/
    base {
        Modifier
            .width(100.percent)
            .display(DisplayStyle.Flex)
            .columnGap(1.cssRem)
            .rowGap(3.cssRem)
    }
    Breakpoint.ZERO {
        Modifier.flexDirection(FlexDirection.ColumnReverse)
    }
    Breakpoint.SM {
        Modifier.flexDirection(FlexDirection.ColumnReverse)
    }
    Breakpoint.MD {
        Modifier.flexDirection(FlexDirection.ColumnReverse)
    }
    Breakpoint.LG {
        Modifier.flexDirection(FlexDirection.Row)
    }
    Breakpoint.XL {
        Modifier.flexDirection(FlexDirection.Row)
    }
}

val ExtraContentDividerStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .background(SitePalette.light.surfaceContainerLow)
    }
    Breakpoint.ZERO {
        Modifier
            .padding(top = 2.5.cssRem, bottom = 2.5.cssRem)
            .height(18.vh)
    }
    Breakpoint.SM {
        Modifier
            .height(15.vh)
            .padding(topBottom = 3.cssRem)
    }
    Breakpoint.MD {
        Modifier.padding(topBottom = 3.4.cssRem)
    }
}
