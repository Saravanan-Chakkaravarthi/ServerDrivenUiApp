package com.serverdrivenapp.presentation.screens.home

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.serverdrivenapp.R
import com.serverdrivenapp.data.JsonParser
import com.serverdrivenapp.data.models.all_matches.MatchesLayoutResponse
import com.serverdrivenapp.data.models.all_matches.ProfileResponse
import com.serverdrivenapp.data.models.all_matches.Profiles
import com.serverdrivenapp.presentation.AppViewModel
import com.serverdrivenapp.presentation.components.ExitAlertDialog
import com.serverdrivenapp.presentation.components.RenderComponent
import com.serverdrivenapp.utils.UiState
import com.serverdrivenapp.utils.loadJsonFromRaw

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: AppViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val layoutState by viewModel.layoutResponse.collectAsState()
    val profileState by viewModel.profileResponse.collectAsState()


    var showDialog by remember {
        mutableStateOf(false)
    }

    // Back press handling
    BackHandler(
        onBack = {
            showDialog = true
        }
    )

    // Back press exit confirmation dialog
    ExitAlertDialog(
        showDialog = showDialog,
        onShowDialog = { isVisible ->
            showDialog = isVisible
        }, context = context as? Activity
    )

    // Observe layout response
    ObserveLayoutResponse(
        state = layoutState,
        profileData = viewModel.matchesProfiles,
        navController = navController
    )

    // observe Profiles response
    ObserveProfilesResponse(
        profileState,
        viewModel.matchesProfiles
    )

    // triggering the api based on the boolean which is sets value in main activity oncreate
    LaunchedEffect(key1 = viewModel.refreshLayoutJson) {
        viewModel.fetchLayout()
        viewModel.fetchProfiles()
    }

}

@Composable
fun ObserveProfilesResponse(
    profileState: UiState<ProfileResponse>,
    matchesProfiles: MutableList<Profiles>
) {
    when(profileState) {
        UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
        is UiState.Success -> {
            matchesProfiles.clear()
            profileState.data.data?.profiles?.let { newProfiles ->
                matchesProfiles.addAll(newProfiles)
            }
        }
        is UiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "No profiles found!!. Please try again later.\n ${profileState.error}",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun ObserveLayoutResponse(
    state: UiState<MatchesLayoutResponse>,
    profileData: List<Profiles>,
    navController: NavController
) {
    when (state) {
        UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }

        is UiState.Success -> {
            Scaffold { innerPadding ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    items(profileData) { profile ->
                        state.data.layout?.components?.forEach { component ->
                            RenderComponent(
                                component = component,
                                navController = navController,
                                profile = profile,
                                onRemove = { profileId ->
                                    Log.d(
                                        "HomeScreen",
                                        "Button clicked from HomeScreen: Removing card with profile ID $profileId"
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }

        is UiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "No profile layout found!!. Please try again later.\n ${state.error}",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}
