package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.serverdrivenapp.data.models.all_matches.MatchesComponents
import com.serverdrivenapp.data.models.all_matches.Profiles
import com.serverdrivenapp.navigation.handleNavigation
import com.serverdrivenapp.utils.hexToColor

@Composable
fun RenderCardComponent(
    component: MatchesComponents,
    navController: NavController,
    profiles: Profiles
) {
    Card(
        onClick = {
            component.properties?.action?.let { action ->
                if (action.type == "Navigation") {
                    handleNavigation(
                        action = action,
                        navController = navController
                    )
                }
            }
        },
        modifier = Modifier
            .widthComponent(input = component.properties?.width)
            .heightComponent(input = component.properties?.height)
            .padding(component.properties?.padding?.dp ?: 0.dp),
        shape = RoundedCornerShape(component.properties?.corner?.dp ?: 0.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = component.properties?.elevation?.dp ?: 0.dp
        ),
        colors = CardDefaults.cardColors(containerColor = hexToColor(component.properties?.cardColor))
    ) {
        component.children?.forEach { child ->
            RenderComponent(component = child, navController = navController, profile = profiles)
        }
    }
}