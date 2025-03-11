package com.serverdrivenapp.presentation.components

import androidx.navigation.NavController
import com.serverdrivenapp.data.models.all_matches.ActionParameter
import com.serverdrivenapp.data.models.all_matches.MatchesAction

fun handleNavigation(action: MatchesAction?, navController: NavController) {
    action?.let {
        if (it.type == "Navigation") {
            val navRoute = buildNavRoute(it.destination ?: "", it.parameters)
            if (navRoute.isNotEmpty()) {
                navController.navigate(navRoute)
            }
        }
    }
}

fun buildNavRoute(destination: String, parameters: ActionParameter?): String {
    return when (destination) {
        "profile_screen" -> {
            parameters?.profileId?.let { "$destination/$it" } ?: destination
        }

        else -> ""
    }
}
