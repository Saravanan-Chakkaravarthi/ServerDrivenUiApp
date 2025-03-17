package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.serverdrivenapp.data.models.all_matches.MatchesComponents
import com.serverdrivenapp.data.models.all_matches.Profiles
import com.serverdrivenapp.utils.hexToColor

@Composable
fun RenderRowComponent(
    component: MatchesComponents,
    navController: NavController,
    profile: Profiles
) {
    // Hide early if the data doesn't meets
    if (profile.isIdVerified == false && component.componentName == "idVerified") {
        return
    }

    Row(
        modifier = Modifier
            .widthComponent(component.properties?.width) // Ensure Row takes proper space
            .heightComponent(component.properties?.height)
            .applyPadding(component.properties?.outerPadding)
            .background(
                color = hexToColor(component.properties?.backgroundColor),
                shape = RoundedCornerShape((component.properties?.corner ?: 0).dp)
            )
            .border(
                width = (component.properties?.borderStroke ?: 0).dp,
                color = hexToColor(component.properties?.strokeColor),
                shape = RoundedCornerShape((component.properties?.corner ?: 0).dp)
            )
            .applyPadding(component.properties?.innerPadding),

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