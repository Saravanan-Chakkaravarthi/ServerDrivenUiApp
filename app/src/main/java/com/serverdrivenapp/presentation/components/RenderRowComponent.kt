package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.serverdrivenapp.data.models.all_matches.MatchesComponents

@Composable
fun RenderRowComponent(component: MatchesComponents, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = HorizontalArrangement.fromString(
            value = component.properties?.horizontalArrangement
        ).arrangement,
        verticalAlignment = VerticalAlignment.fromString(
            value = component.properties?.verticalAlignment
        ).alignment
    ) {
        component.children?.forEach { child ->
            RenderComponent(component = child, navController = navController)
        }
    }
}

sealed class HorizontalArrangement(
    val arrangement: Arrangement.Horizontal
) {
    data object Top : HorizontalArrangement(Arrangement.Start)
    data object Center : HorizontalArrangement(Arrangement.Center)
    data object Bottom : HorizontalArrangement(Arrangement.End)
    data object SpaceAround : HorizontalArrangement(Arrangement.SpaceAround)
    data object SpaceBetween : HorizontalArrangement(Arrangement.SpaceBetween)
    data object SpaceEvenly : HorizontalArrangement(Arrangement.SpaceEvenly)

    companion object {
        fun fromString(value: String?): HorizontalArrangement {
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

sealed class VerticalAlignment(val alignment: Alignment.Vertical) {
    data object CenterHorizontally : VerticalAlignment(Alignment.CenterVertically)
    data object CenterVertically : VerticalAlignment(Alignment.CenterVertically)
    data object Start : VerticalAlignment(Alignment.Top)
    data object End : VerticalAlignment(Alignment.Bottom)

    companion object {
        fun fromString(value: String?): VerticalAlignment {
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