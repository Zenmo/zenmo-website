import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.zenmo.web.zenmo.SitePalettes
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent

val MenuItemParentStyle = CssStyle {
    base {
        Modifier
            .position(Position.Relative)
    }

    hover {
        Modifier
            .styleModifier {
                property("--dropdown-visibility", "block")
            }
    }
}

val DropdownContainerStyle = CssStyle {
    base {
        Modifier
            .position(Position.Absolute)
            .top(100.percent)
            .right(0.percent)
            .padding(0.5.cssRem)
            .backgroundColor(SitePalettes.light.brand.surfaceContainerLowLight)
            .borderRadius(0.5.cssRem)
            .boxShadow(
                0.cssRem,
                0.cssRem,
                blurRadius = 0.5.cssRem,
                color = Colors.LightGray
            )
            .display(DisplayStyle.None)
            .zIndex(10)
            /*todo ease-in ease-out transition animation for this*/
            .styleModifier {
                property("display", "var(--dropdown-visibility, none)")
            }

    }
}

val DropdownItemStyle = CssStyle {
    base {
        Modifier
            .padding(0.5.cssRem)
            .display(DisplayStyle.Block)
            .color(SitePalettes.light.brand.onBackgroundLight)
    }
    hover {
        Modifier
            .backgroundColor(SitePalettes.light.brand.primary)
            .borderRadius(0.5.cssRem)
            .color(SitePalettes.light.brand.onPrimaryLight)
    }
}