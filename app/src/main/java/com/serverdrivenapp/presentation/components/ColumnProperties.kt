package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment

// Center, Top, Bottom, SpaceAround, SpaceBetween, SpaceEvenly, SpaceBy

sealed class VerticalArrangement(
    val arrangement: Arrangement.Vertical
) {
    data object Top : VerticalArrangement(Arrangement.Top)
    data object Center : VerticalArrangement(Arrangement.Center)
    data object Bottom : VerticalArrangement(Arrangement.Bottom)
    data object SpaceAround : VerticalArrangement(Arrangement.SpaceAround)
    data object SpaceBetween : VerticalArrangement(Arrangement.SpaceBetween)
    data object SpaceEvenly : VerticalArrangement(Arrangement.SpaceEvenly)

    companion object {
        fun fromString(value: String?): VerticalArrangement {
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

sealed class HorizontalAlignment(val alignment: Alignment.Horizontal) {
    data object CenterHorizontally : HorizontalAlignment(Alignment.CenterHorizontally)
    data object Start : HorizontalAlignment(Alignment.Start)
    data object End : HorizontalAlignment(Alignment.End)

    companion object {
        fun fromString(value: String?): HorizontalAlignment {
            return when (value) {
                "CenterHorizontally" -> CenterHorizontally
                "Start" -> Start
                "End" -> End
                else -> Start // Default case
            }
        }
    }
}