package ru.w_2_wmatch.view.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.w_2_wmatch.domain.AppState
import ru.w_2_wmatch.domain.models.AuthUser
import ru.w_2_wmatch.domain.usecases.AuthUseCase

class AuthViewModel(private val authUseCase: AuthUseCase) : ViewModel() {
    private val _appStateFlow = MutableStateFlow<AppState>(AppState.None)
    val appStateFlow: StateFlow<AppState> = _appStateFlow

    fun auth(authUser: AuthUser) {
        viewModelScope.launch {
            _appStateFlow.emit(AppState.Loading)
            /***Временно во время разработки, если пустые поля пропускаем пользователя дальше*/
            if (authUser.login.isEmpty() and authUser.password.isEmpty()) {
                _appStateFlow.emit(AppState.Success(true))
            } else {
                _appStateFlow.emit(AppState.Success(authUseCase(authUser)))
            }
        }
    }

    class Factory(
        private val authUseCase: AuthUseCase
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
                return AuthViewModel(
                    authUseCase = authUseCase,
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}