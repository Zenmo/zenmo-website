package com.zenmo.web.zenmo.components.widgets.user

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLogin
import com.zenmo.web.zenmo.components.widgets.IconLink
import com.zenmo.web.zenmo.core.services.auth.UserService
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px

@Composable
fun LoginButton(userService: UserService) {
    IconLink(href = userService.loginUrl()) {
        MdiLogin(
            modifier = Modifier.Companion.position(Position.Companion.Relative).right(2.px)
        )
    }
}
