package com.zenmo.web.zenmo.protected

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.zenmo.web.zenmo.components.widgets.user.LoginButton
import com.zenmo.web.zenmo.core.services.auth.UserService
import com.zenmo.web.zenmo.domains.lux.widgets.headings.SubHeaderText
import org.jetbrains.compose.web.css.cssRem

@Composable
fun Login() {
    val userService = UserService()
    Column(
        modifier = Modifier.fillMaxWidth().gap(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubHeaderText(
            enText = "Login to continue",
            nlText = "Log in om door te gaan",
            modifier = Modifier.margin(0.cssRem)
        )
        LoginButton(userService)
    }
}