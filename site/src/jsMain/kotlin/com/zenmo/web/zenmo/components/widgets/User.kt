package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLogin
import com.zenmo.web.zenmo.core.services.auth.UserService
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px

/**
 * Entry point to log in, log out, register and change profile.
 * 
 * First version is just a login button
 */
@Composable
fun UserMenuWidget() {
    LoginButton()
}

@Composable
fun LoginButton() {
    IconLink(href = UserService().loginUrl()) {
        MdiLogin(
            modifier = Modifier.position(Position.Relative).right(2.px)
        )
    }
}
