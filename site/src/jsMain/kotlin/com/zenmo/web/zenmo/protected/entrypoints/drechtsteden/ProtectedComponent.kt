package com.zenmo.web.zenmo.protected.entrypoints.drechtsteden

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.components.widgets.LangText
import energy.lux.site.shared.AccessPolicy
import org.jetbrains.compose.web.dom.Span

@JsExport
val accessPolicy = AccessPolicy.RoleBased("Drechtsteden")

@JsExport
@Composable
fun ProtectedComponent() {
    Span {
        LangText(
            en = "Very secret text just for Drechtsteden",
            nl = "Geheime text alleen voor Drechtsteden",
        )
    }
}
