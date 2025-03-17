package com.serverdrivenapp.presentation.components

import androidx.compose.ui.Alignment

sealed class BoxAlignment(val alignment: Alignment) {
    // TopStart, TopCenter, TopEnd, CenterStart, Center, CenterEnd, BottomStart, BottomCenter, BottomEnd
    data object TopStart : BoxAlignment(Alignment.TopStart)
    data object TopCenter : BoxAlignment(Alignment.TopCenter)
    data object TopEnd : BoxAlignment(Alignment.TopEnd)
    data object CenterStart : BoxAlignment(Alignment.CenterStart)
    data object Center : BoxAlignment(Alignment.Center)
    data object CenterEnd : BoxAlignment(Alignment.CenterEnd)
    data object BottomStart : BoxAlignment(Alignment.BottomStart)
    data object BottomCenter : BoxAlignment(Alignment.BottomCenter)
    data object BottomEnd : BoxAlignment(Alignment.BottomEnd)

    companion object {
        fun fromString(value: String?): BoxAlignment {
            return when (value) {
                "TopStart" -> TopStart
                "TopCenter" -> TopCenter
                "TopEnd" -> TopEnd
                "CenterStart" -> CenterStart
                "Center" -> Center
                "CenterEnd" -> CenterEnd
                "BottomStart" -> BottomStart
                "BottomCenter" -> BottomCenter
                "BottomEnd" -> BottomEnd
                else -> Center
            }
        }
    }
}