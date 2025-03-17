package com.serverdrivenapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serverdrivenapp.data.models.all_matches.MatchesLayoutResponse
import com.serverdrivenapp.data.models.all_matches.ProfileResponse
import com.serverdrivenapp.data.models.all_matches.Profiles
import com.serverdrivenapp.domain.repository.AppRepository
import com.serverdrivenapp.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    var refreshLayoutJson: Boolean = false
    val matchesProfiles: MutableList<Profiles> = mutableListOf()

    private var _layoutResponse: MutableStateFlow<UiState<MatchesLayoutResponse>> =
        MutableStateFlow(UiState.Loading)
    val layoutResponse = _layoutResponse.asStateFlow()

    private var _profileResponse: MutableStateFlow<UiState<ProfileResponse>> =
        MutableStateFlow(UiState.Loading)
    val profileResponse = _profileResponse.asStateFlow()

    fun fetchLayout() {
        viewModelScope.launch {
            try {
                _profileResponse.value = UiState.Success(repository.fetchProfileResponse())
            } catch (e: Exception) {
                Log.d("TAG", "fetchLayout: ${e.message}")
                _profileResponse.value = UiState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }

    fun fetchProfiles() {
        viewModelScope.launch {
            try {
                _layoutResponse.value = UiState.Success(repository.fetchLayoutResponse())
            } catch (e: Exception) {
                Log.d("TAG", "fetchLayout: ${e.message}")
                _layoutResponse.value = UiState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }
}