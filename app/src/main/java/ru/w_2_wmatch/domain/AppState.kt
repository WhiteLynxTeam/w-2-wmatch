package ru.w_2_wmatch.domain

sealed class AppState {
    data class Success<out T>(val data: T) : AppState()
    data class Error(val error: Throwable) : AppState()
    data object Loading : AppState()
    data object None : AppState()
}
