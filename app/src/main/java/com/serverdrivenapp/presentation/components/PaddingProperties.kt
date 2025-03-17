package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.serverdrivenapp.data.models.all_matches.PaddingData

fun Modifier.applyPadding(padding: PaddingData?): Modifier {
    return when {
        padding?.all != null -> this.padding(all = padding.all.dp)
        padding?.horizontal != null && padding.vertical != null ->
            this.padding(
                horizontal = padding.horizontal.dp,
                vertical = padding.vertical.dp
            )

        else -> this.padding(
            start = padding?.start?.dp ?: 0.dp,
            top = padding?.top?.dp ?: 0.dp,
            end = padding?.end?.dp ?: 0.dp,
            bottom = padding?.bottom?.dp ?: 0.dp
        )
    }
}