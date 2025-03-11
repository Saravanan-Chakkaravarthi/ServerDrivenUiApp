package com.serverdrivenapp.utils

sealed interface UiState<out T> {
    data object Loading: UiState<Nothing>
    data class Success<out T>(val data: T): UiState<T>
    data class Error(val error: Any): UiState<Nothing>
}