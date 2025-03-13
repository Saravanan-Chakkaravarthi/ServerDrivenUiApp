package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.serverdrivenapp.data.models.all_matches.MatchesComponents

@Composable
fun RenderSpacerComponent(component: MatchesComponents) {
    Spacer(modifier = Modifier
        .widthComponent(component.properties?.width)
        .heightComponent(component.properties?.height)
    )
}