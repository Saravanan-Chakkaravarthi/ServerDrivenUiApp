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

@Composable
fun RenderCardComponent(component: MatchesComponents, navController: NavController) {
    Card(
        modifier = Modifier
            .widthComponent(input = component.properties?.width)
            .heightComponent(input = component.properties?.height)
            .padding(component.properties?.padding?.dp ?: 0.dp),
        shape = RoundedCornerShape(component.properties?.corner?.dp ?: 0.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = component.properties?.elevation?.dp ?: 0.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Color.Cyan)
    ) {
        component.children?.forEach { child ->
            RenderComponent(component = child, navController = navController)
        }
    }
}