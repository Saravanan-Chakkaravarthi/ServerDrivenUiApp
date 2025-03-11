package com.serverdrivenapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.serverdrivenapp.presentation.screens.home.HomeScreen
import com.serverdrivenapp.presentation.screens.profile.ProfileScreen

@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.Home.route
    ) {
        composable(
            route = Screens.Home.route
        ) {
            HomeScreen(navHostController)
        }

        composable(
            route = Screens.Profile.route
        ) { backStackEntry ->
            val profileId = backStackEntry.arguments?.getString("profileId") ?: ""
            ProfileScreen(navController = navHostController, profileId)
        }
    }
}

sealed class Screens(val route: String) {
    data object Home: Screens("home_screen")
    data object Profile: Screens("profile_screen/{profileId}")
}