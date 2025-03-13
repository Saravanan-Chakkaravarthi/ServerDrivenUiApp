package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.serverdrivenapp.data.models.all_matches.MatchesComponents
import com.serverdrivenapp.data.models.all_matches.Profiles

@Composable
fun RenderLazyRowComponent(
    component: MatchesComponents,
    navController: NavController,
    profile: Profiles
) {
    LazyRow(
        modifier = Modifier
            .widthComponent(component.properties?.width)
            .heightComponent(component.properties?.height),
        state = rememberLazyListState(),
        flingBehavior = ScrollableDefaults.flingBehavior(),
        horizontalArrangement = RowHorizontalArrangement.fromString(
            component.properties?.horizontalArrangement
        ).arrangement,
        verticalAlignment = RowVerticalAlignment.fromString(
            component.properties?.verticalAlignment
        ).alignment
    ) {
        items(component.children ?: emptyList()) { child ->
            RenderComponent(component = child, navController = navController, profile = profile)
        }
    }
}