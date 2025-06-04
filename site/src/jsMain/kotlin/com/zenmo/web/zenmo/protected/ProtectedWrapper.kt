package com.zenmo.web.zenmo.protected

import androidx.compose.runtime.*
import com.varabyte.kobweb.core.AppGlobals
import com.zenmo.web.zenmo.components.widgets.ErrorWidget
import js.import.importAsync
import web.http.RequestCredentials
import web.http.RequestInit
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
        try {
            privateModule = importAsync<PrivateTextModule>("./entrypoints/$entryPoint/ProtectedComponent.export.mjs").await()
            status = LoadingState.SUCCESS
        } catch (e: Throwable) {
            /**
             * We get no status code after import failure.
             * To determine the status code, we do the same request again using AJAX.
             */
            val fileName = e.message?.substringAfterLast('/')
            if (fileName == null) {
                error = e
                return@LaunchedEffect
            }

            try {
                val response = fetch(AppGlobals.getValue("BACKEND_URL") + "/" + fileName, RequestInit(
                    credentials = RequestCredentials.include
                ))
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
