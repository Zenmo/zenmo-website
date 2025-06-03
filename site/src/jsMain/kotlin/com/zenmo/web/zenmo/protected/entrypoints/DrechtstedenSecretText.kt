package com.zenmo.web.zenmo.protected.entrypoints

import androidx.compose.runtime.Composable
import energy.lux.site.shared.AccessPolicy
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Drechtsteden")

@JsExport
@Composable
fun ProtectedComponent() {
    Span {
        Text("Very secret text one")
    }
}
