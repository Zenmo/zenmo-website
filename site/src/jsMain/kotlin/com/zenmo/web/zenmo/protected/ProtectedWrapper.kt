package com.zenmo.web.zenmo.protected

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.core.AppGlobals
import com.zenmo.web.zenmo.components.widgets.LangText
import js.import.importAsync
import org.jetbrains.compose.web.dom.Text
import web.http.fetch

external interface PrivateTextModule {
    @Composable fun ProtectedComponent()
}

private enum class LoadingState {
    PENDING,
    NOT_LOGGED_IN,
    NOT_ENOUGH_PRIVILEGES,
    ERROR,
    SUCCESS,
}

@Composable
fun ProtectedWrapper(entryPoint: String) {
    var privateModule by remember { mutableStateOf<PrivateTextModule?>(null) }
    var error by remember { mutableStateOf<Throwable?>(null) }
    var status by remember { mutableStateOf(LoadingState.PENDING) }

    LaunchedEffect(Unit) {
        /**
         * Can't use the simpler suspend variant
         * because the KotlinJS compiler puts the argument in a temporary variable
         * and Rollup can't resolve that.
         *
         * A workaround/improvement would be to put all private entrypoints in a dedicated folder.
         */
        try {
            privateModule = importAsync<PrivateTextModule>("./entrypoints/$entryPoint.export.mjs").await()
            status = LoadingState.SUCCESS
        } catch (e: Throwable) {
            val fileName = e.message?.substringAfterLast('/')
            if (fileName == null) {
                error = e
                return@LaunchedEffect
            }

            try {
                val response = fetch(AppGlobals.getValue("BACKEND_URL") + "/" + fileName)
                status = when (response.status.toInt()) {
                    401 -> LoadingState.NOT_LOGGED_IN
                    403 -> LoadingState.NOT_ENOUGH_PRIVILEGES
                    else -> LoadingState.ERROR
                }
            } catch (e: Throwable) {
                status = LoadingState.ERROR
                error = e
            }
        }
    }

    when (status) {
        LoadingState.PENDING -> LangText(en = "Pending...", nl = "Bezig...")
        LoadingState.NOT_LOGGED_IN -> Text("NOT_LOGGED_IN")
        LoadingState.NOT_ENOUGH_PRIVILEGES -> Text("NOT_ENOUGH_PRIVILEGES")
        LoadingState.ERROR -> {
            LangText(en = "Error", nl = "Error")
            if (error != null) {
                Text(error.toString())
            }
        }
        LoadingState.SUCCESS -> privateModule!!.ProtectedComponent()
    }
}
