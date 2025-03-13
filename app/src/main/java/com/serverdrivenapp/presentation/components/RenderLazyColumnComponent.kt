package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.serverdrivenapp.data.models.all_matches.MatchesComponents
import com.serverdrivenapp.data.models.all_matches.Profiles

@Composable
fun RenderLazyColumnComponent(
    components: MatchesComponents,
    navController: NavController,
    profiles: Profiles
) {
    LazyColumn(
        modifier = Modifier
            .widthComponent(components.properties?.width)
            .heightComponent(components.properties?.height),
    ) {
        items(components.children ?: emptyList()) { child ->
            RenderComponent(component = child, navController = navController, profile = profiles)
        }
    }
}

