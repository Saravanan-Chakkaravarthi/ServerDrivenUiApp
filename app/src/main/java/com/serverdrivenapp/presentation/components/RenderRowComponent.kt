package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.serverdrivenapp.data.models.all_matches.MatchesComponents
import com.serverdrivenapp.data.models.all_matches.Profiles

@Composable
fun RenderRowComponent(
    component: MatchesComponents,
    navController: NavController,
    profile: Profiles
) {
    Row(
        modifier = Modifier
            .widthComponent(component.properties?.width)
            .heightComponent(component.properties?.height),
        horizontalArrangement = RowHorizontalArrangement.fromString(
            value = component.properties?.horizontalArrangement
        ).arrangement,
        verticalAlignment = RowVerticalAlignment.fromString(
            value = component.properties?.verticalAlignment
        ).alignment,

    ) {
        component.children?.forEach { child ->
            RenderComponent(component = child, navController = navController, profile)
        }
    }
}