package com.serverdrivenapp.navigation

import androidx.navigation.NavController
import com.serverdrivenapp.data.models.all_matches.ActionParameter
import com.serverdrivenapp.data.models.all_matches.MatchesAction
import com.serverdrivenapp.data.models.all_matches.Profiles

fun handleNavigation(action: MatchesAction?, navController: NavController, profile: Profiles) {
    action?.let {
        if (it.type == "Navigation") {
            val navRoute = buildNavRoute(
                destination = it.destination ?: "",
                parameters = it.parameters,
                profile = profile
            )
            if (navRoute.isNotEmpty()) {
                navController.navigate(navRoute)
            }
        }
    }
}

fun buildNavRoute(destination: String, parameters: ActionParameter?, profile: Profiles): String {
    return when (destination) {
        "profile_screen" -> {
            parameters?.profileId?.let { "$destination/${profile.profileId}" } ?: destination
        }

        else -> ""
    }
}
