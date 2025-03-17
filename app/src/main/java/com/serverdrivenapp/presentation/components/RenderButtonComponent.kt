package com.serverdrivenapp.presentation.components

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.serverdrivenapp.data.models.all_matches.MatchesAction
import com.serverdrivenapp.data.models.all_matches.MatchesComponents
import com.serverdrivenapp.data.models.all_matches.Profiles
import com.serverdrivenapp.navigation.handleNavigation
import com.serverdrivenapp.utils.hexToColor

@Composable
fun RenderButtonComponent(
    component: MatchesComponents,
    navController: NavController,
    profile: Profiles,
    onRemove: (String?) -> Unit
) {
    val context = LocalContext.current
    Button(
        onClick = {
            Log.d("SDUI", "Button clicked from button component for profileId: ${profile.profileId}")
            component.properties?.action?.let { action ->
                handleButtonClick(
                    context = context,
                    action = action,
                    navController = navController,
                    profile = profile,
                    onRemove = onRemove,
                )
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
            .heightComponent(input = component.properties?.height)
            .applyPadding(component.properties?.innerPadding),
        shape = if (component.properties?.shape == "roundedCornerShape")
            RoundedCornerShape(
                (component.properties.corner ?: 0).dp
            ) else ButtonDefaults.shape
    ) {
        component.children?.forEach { child ->
            RenderComponent(component = child, navController = navController, profile = profile, {})
        }
    }
}

fun handleButtonClick(
    context: Context,
    action: MatchesAction?,
    navController: NavController,
    profile: Profiles,
    onRemove: (String?) -> Unit
) {
    when (action?.type) {
        "Navigation" -> handleNavigation(
            action = action,
            navController = navController,
            profile = profile
        )

        "RemoveCard" -> {
            Log.d("ButtonCLick", "Button clicked for profileId: ${profile.profileId}")
            Toast.makeText(context, "Tapping Remove card functionality", Toast.LENGTH_SHORT).show()
            onRemove(profile.profileId)
        }
    }
}