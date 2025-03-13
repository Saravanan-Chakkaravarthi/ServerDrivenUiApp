package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Modifier.widthComponent(input: String?): Modifier {
    return when(input) {
        "match_parent" -> this.fillMaxWidth()
        "wrap_content" -> this.wrapContentWidth()
        else -> this.width(input?.toIntOrNull()?.dp ?: Dp.Unspecified)
    }
}

@Composable
fun Modifier.heightComponent(input: String?): Modifier {
    return when(input) {
        "match_parent" -> this.fillMaxHeight()
        "wrap_content" -> this.wrapContentHeight()
        else -> this.height(input?.toIntOrNull()?.dp ?: Dp.Unspecified)
    }
}