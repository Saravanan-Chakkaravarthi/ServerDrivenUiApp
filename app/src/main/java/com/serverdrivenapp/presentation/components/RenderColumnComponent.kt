package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.serverdrivenapp.data.models.all_matches.MatchesComponents
import com.serverdrivenapp.data.models.all_matches.Profiles

@Composable
fun RenderColumnComponent(
    component: MatchesComponents,
    navController: NavController,
    profiles: Profiles
) {
    Column(
        modifier = Modifier
            .widthComponent(input = component.properties?.width)
            .heightComponent(input = component.properties?.height)
            .applyPadding(component.properties?.innerPadding),
        verticalArrangement = VerticalArrangement.fromString(
            value = component.properties?.verticalArrangement).arrangement,
        horizontalAlignment = HorizontalAlignment.fromString(
            value = component.properties?.horizontalAlignment
        ).alignment
    ) {
        component.children?.forEach { component ->
            RenderComponent(component = component, navController = navController, profile = profiles)
        }
    }
}