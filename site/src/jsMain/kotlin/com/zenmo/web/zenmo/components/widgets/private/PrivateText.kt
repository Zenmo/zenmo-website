package com.zenmo.web.zenmo.components.widgets.private

import androidx.compose.runtime.Composable
import energy.lux.site.shared.AccessPolicy
import org.jetbrains.compose.web.dom.Text

@JsExport
val accessPolicy = AccessPolicy.RoleBased("admin")

/**
 * This is a component to test/demo private components
 */
@JsExport
@Composable
fun PrivateText() {
    Text("Secret text which should not go in the main bundle")
}
