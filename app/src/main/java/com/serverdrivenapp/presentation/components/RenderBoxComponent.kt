package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.serverdrivenapp.data.models.all_matches.MatchesComponents
import com.serverdrivenapp.data.models.all_matches.Profiles

@Composable
fun RenderBoxComponent(
    components: MatchesComponents,
    navController: NavController,
    profiles: Profiles
) {
    Box(
        modifier = Modifier
            .widthComponent(components.properties?.width)
            .heightComponent(components.properties?.height)
            .applyPadding(components.properties?.innerPadding)
            .clip(RoundedCornerShape((components.properties?.corner ?: 0).dp)),
        contentAlignment = BoxAlignment.fromString(components.properties?.alignment).alignment
    ) {
        components.children?.forEach { component ->
            Box(
                modifier = Modifier
                    .align(
                        BoxAlignment.fromString(component.properties?.alignment).alignment
                    )
            ) {
                RenderComponent(component = component, navController = navController, profiles)
            }
        }
    }
}
