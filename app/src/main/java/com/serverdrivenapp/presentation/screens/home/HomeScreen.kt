package com.serverdrivenapp.presentation.screens.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.serverdrivenapp.R
import com.serverdrivenapp.data.JsonParser
import com.serverdrivenapp.data.models.all_matches.Matches
import com.serverdrivenapp.data.models.all_matches.ProfileResponse
import com.serverdrivenapp.presentation.components.ExitAlertDialog
import com.serverdrivenapp.presentation.components.RenderComponent
import com.serverdrivenapp.utils.loadJsonFromRaw

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    var showDialog by remember {
        mutableStateOf(false)
    }

    val jsonString = loadJsonFromRaw(R.raw.all_matches_response, LocalContext.current)
    val screenData = JsonParser.fromJson<Matches>(jsonString)

    val jsonProfileString = loadJsonFromRaw(R.raw.profiles, LocalContext.current)
    val profileData = JsonParser.fromJson<ProfileResponse>(jsonProfileString)

    BackHandler(
        onBack = {
            showDialog = true
        }
    )

    ExitAlertDialog(
        showDialog = showDialog,
        onShowDialog = { isVisible ->
            showDialog = isVisible
        }, context = context as? Activity
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        ) { innerPadding ->
        /*Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
//                .verticalScroll(rememberScrollState())
        ) {
            RenderSDUIScreen(
                screen = screenData,
                profileData = profileData,
                navController = navController
            )
        }*/
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            items(profileData.data?.profiles ?: emptyList()) { profile ->
                screenData.layout?.components?.forEach { component ->
                    RenderComponent(
                        component = component,
                        navController = navController,
                        profile = profile
                    )
                }
            }
        }
    }
}