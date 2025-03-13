package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment

sealed class RowHorizontalArrangement(
    val arrangement: Arrangement.Horizontal
) {
    data object Top : RowHorizontalArrangement(Arrangement.Start)
    data object Center : RowHorizontalArrangement(Arrangement.Center)
    data object Bottom : RowHorizontalArrangement(Arrangement.End)
    data object SpaceAround : RowHorizontalArrangement(Arrangement.SpaceAround)
    data object SpaceBetween : RowHorizontalArrangement(Arrangement.SpaceBetween)
    data object SpaceEvenly : RowHorizontalArrangement(Arrangement.SpaceEvenly)

    companion object {
        fun fromString(value: String?): RowHorizontalArrangement {
            return when (value) {
                "Center" -> Center
                "Top" -> Top
                "Bottom" -> Bottom
                "SpaceAround" -> SpaceAround
                "SpaceBetween" -> SpaceBetween
                "SpaceEvenly" -> SpaceEvenly
                else -> Top // Default case
            }
        }
    }
}

sealed class RowVerticalAlignment(val alignment: Alignment.Vertical) {
    data object CenterHorizontally : RowVerticalAlignment(Alignment.CenterVertically)
    data object CenterVertically : RowVerticalAlignment(Alignment.CenterVertically)
    data object Start : RowVerticalAlignment(Alignment.Top)
    data object End : RowVerticalAlignment(Alignment.Bottom)

    companion object {
        fun fromString(value: String?): RowVerticalAlignment {
            return when (value) {
                "CenterHorizontally" -> CenterHorizontally
                "CenterVertically" -> CenterVertically
                "Start" -> Start
                "End" -> End
                else -> Start // Default case
            }
        }
    }
}