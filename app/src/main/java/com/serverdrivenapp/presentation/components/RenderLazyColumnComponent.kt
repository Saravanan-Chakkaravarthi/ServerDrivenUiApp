package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.serverdrivenapp.data.models.all_matches.MatchesComponents

@Composable
fun RenderLazyColumnComponent(
    components: MatchesComponents,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .widthComponent(components.properties?.width)
            .heightComponent(components.properties?.height),
    ) {
        items(components.children ?: emptyList()) { child ->
            RenderComponent(component = child, navController = navController)
        }
    }
}

