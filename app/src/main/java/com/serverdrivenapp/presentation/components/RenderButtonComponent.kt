package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.serverdrivenapp.data.models.all_matches.MatchesComponents
import com.serverdrivenapp.utils.hexToColor

@Composable
fun RenderButtonComponent(component: MatchesComponents, navController: NavController) {
    Button(
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
        colors = ButtonDefaults.buttonColors(
            containerColor = hexToColor(
                component.properties?.backgroundColor
            )
        ),
        border = if (component.properties?.borderStroke != null)
            BorderStroke(
                width = component.properties.borderStroke.dp,
                color = hexToColor(component.properties.strokeColor)
            )
        else null,
        modifier = Modifier
            .widthComponent(input = component.properties?.width)
            .heightComponent(input = component.properties?.height),
        shape = if (component.properties?.shape == "roundedCornerShape")
            RoundedCornerShape(
                (component.properties.corner ?: 0).dp
            ) else ButtonDefaults.shape
    ) {
        component.children?.forEach { child ->
            RenderComponent(component = child, navController = navController)
        }
    }
}