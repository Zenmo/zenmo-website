package com.zenmo.web.zenmo.components.widgets.user

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.icons.mdi.MdiLogout
import com.zenmo.web.zenmo.components.widgets.LangText
import com.zenmo.web.zenmo.core.services.auth.UserService
import kotlinx.coroutines.launch

@Composable
fun LogoutButton(
    userService: UserService,
    onLogout: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    Button(onClick = {
        coroutineScope.launch {
            userService.logout()
            onLogout()
        }
    }) {
        MdiLogout()
        LangText(
            en = "Log out",
            nl = "Uitloggen",
        )
    }
}
