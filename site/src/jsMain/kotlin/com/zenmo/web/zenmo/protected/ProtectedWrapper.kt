package com.zenmo.web.zenmo.protected

import androidx.compose.runtime.*
import com.varabyte.kobweb.core.AppGlobals
import com.zenmo.web.zenmo.components.widgets.ErrorWidget
import js.import.importAsync
import web.http.fetch

external interface PrivateTextModule {
    @Composable
    fun ProtectedComponent()
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
        LoadingState.PENDING -> Pending()
        LoadingState.NOT_LOGGED_IN -> Login()
        LoadingState.NOT_ENOUGH_PRIVILEGES -> NotEnoughPrivileges()
        LoadingState.ERROR -> ErrorWidget(errorMessage = error?.toString() ?: "An unknown error occurred.")
        LoadingState.SUCCESS -> privateModule!!.ProtectedComponent()
    }
}
