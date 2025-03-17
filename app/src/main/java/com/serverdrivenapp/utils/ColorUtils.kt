package com.serverdrivenapp.utils

import androidx.compose.ui.graphics.Color

fun hexToColor(hex: String?): Color {
    return try {
        if (hex.isNullOrEmpty()) Color.Transparent
        else Color(android.graphics.Color.parseColor(hex))
    } catch (e: IllegalArgumentException) {
        Color.Transparent
    }
}