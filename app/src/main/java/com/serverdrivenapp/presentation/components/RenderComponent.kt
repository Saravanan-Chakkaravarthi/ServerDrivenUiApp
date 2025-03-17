package com.serverdrivenapp.presentation.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.serverdrivenapp.data.models.all_matches.MatchesComponents
import com.serverdrivenapp.data.models.all_matches.Profiles

@Composable
fun RenderComponent(
    component: MatchesComponents,
    navController: NavController,
    profile: Profiles,
    onRemove: ((String?) -> Unit)? = null
) {

    when (component.type) {
        "LazyColumn" -> RenderLazyColumnComponent(
            components = component,
            navController = navController,
            profiles = profile
        )

        "LazyRow" -> RenderLazyRowComponent(component, navController, profile)

        "Column" -> RenderColumnComponent(
            component = component,
            navController = navController,
            profile
        )

        "Row" -> RenderRowComponent(
            component = component,
            navController = navController,
            profile = profile
        )

        "Box" -> RenderBoxComponent(
            components = component,
            navController = navController,
            profiles = profile
        )

        "Card" -> RenderCardComponent(component = component, navController = navController, profile)
        "Image" -> RenderImageComponent(component = component, profile = profile)
        "Text" -> RenderTextComponent(component = component, profile = profile)
        "Button" -> RenderButtonComponent(
            component = component,
            navController = navController,
            profile,
            onRemove = {
                Log.d("SDUI", "Button clicked from renderComponent for profileId: ${profile.profileId}")
                onRemove?.let { remove -> remove(profile.profileId) }
            }
        )


        "Icon" -> RenderIconComponent(component = component)
        "Spacer" -> RenderSpacerComponent(component = component)
    }
}
