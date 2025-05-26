package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.left
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLogin
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLogout
import com.zenmo.web.zenmo.core.services.auth.UserService
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.IconButton
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px

/**
 * Entry point to log in, log out, register and change profile.
 * 
 * First version is just a login button
 */
@Composable
fun UserMenuWidget() {
    val userService = UserService()
    var isLoggedIn by remember { mutableStateOf<Boolean?>(null) }

    LaunchedEffect(Unit) {
        isLoggedIn = userService.isLoggedIn()
    }

    when (isLoggedIn) {
        false -> LoginButton(userService)
        true -> LogoutButton(userService, onLogout = { isLoggedIn = false })
        else -> Unit
    }
}

@Composable
fun LoginButton(userService: UserService) {
    IconLink(href = userService.loginUrl()) {
        MdiLogin(
            modifier = Modifier.position(Position.Relative).right(2.px)
        )
    }
}

@Composable
fun LogoutButton(
    userService: UserService,
    onLogout: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    IconButton(onClick = {
        coroutineScope.launch {
            userService.logout()
            onLogout()
        }
    }) {
        MdiLogout(
            modifier = Modifier.position(Position.Relative).left(2.px)
        )
    }
}
