package com.serverdrivenapp.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.serverdrivenapp.R
import com.serverdrivenapp.data.JsonParser
import com.serverdrivenapp.data.models.all_matches.Matches
import com.serverdrivenapp.presentation.components.RenderSDUIScreen
import com.serverdrivenapp.utils.loadJsonFromRaw

@Composable
fun HomeScreen(navController: NavController) {

    val jsonString = loadJsonFromRaw(R.raw.all_matches_response, LocalContext.current)
    val screenData = JsonParser.fromJson<Matches>(jsonString)

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            RenderSDUIScreen(screen = screenData, navController = navController)
        }
    }
}