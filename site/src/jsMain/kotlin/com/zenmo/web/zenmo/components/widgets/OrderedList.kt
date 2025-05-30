package com.zenmo.web.zenmo.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Ol

@Composable
fun OrderedList(
    items: List<@Composable () -> Unit>
) {
    Ol {
        items.forEach { composable ->
            Li {
                composable()
            }
        }
    }
}