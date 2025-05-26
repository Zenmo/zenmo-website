package com.zenmo.web.zenmo.components.widgets.user

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.zenmo.web.zenmo.core.services.auth.UserService
import com.zenmo.web.zenmo.domains.zenmo.widgets.button.IconButton
import energy.lux.site.shared.UserInfo
import kotlinx.browser.document
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

/**
 * Entry point to log in, log out, register and change profile.
 *
 * First version is just a login button
 */
@Composable
fun UserMenuWidget() {
    val userService = UserService()
    var userInfo by remember { mutableStateOf<UserInfo?>(null) }
    var pending by remember { mutableStateOf(true) }
    var showDropdown by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        document.body?.onclick = {
            showDropdown = false
        }
        userInfo = userService.userInfo()
        pending = false
    }

    if (pending) {
        return
    }

    if (userInfo == null) {
        LoginButton(userService)
        return
    }

    Column(modifier = Modifier.position(Position.Relative)) {
        Row {
            UserIconButton(userInfo = userInfo!!, onClick = { showDropdown = !showDropdown })
        }
        if (showDropdown) {
            Row(modifier = Modifier.position(Position.Absolute).top(100.percent).right(0.px)) {
                UserMenu(userService = userService, onLogout = { userInfo = null })
            }
        }
    }
}

@Composable
fun UserIconButton(userInfo: UserInfo, onClick: () -> Unit) {
    IconButton(onClick = onClick, modifier = Modifier.width(2.cssRem)) {
        Text(userInfo.iconLetters())
    }
}

@Composable
fun UserMenu(userService: UserService, onLogout: () -> Unit,) {
    Column {
        Row {
            LogoutButton(userService = userService, onLogout)
        }
    }
}

