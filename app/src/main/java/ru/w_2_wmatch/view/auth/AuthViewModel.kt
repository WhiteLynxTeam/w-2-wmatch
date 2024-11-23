package ru.w_2_wmatch.view.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.w_2_wmatch.domain.models.AuthUser
import ru.w_2_wmatch.domain.usecases.AuthUseCase

class AuthViewModel(private val authUseCase: AuthUseCase) : ViewModel() {

    private var _isEntry = MutableSharedFlow<Boolean>()
    val isEntry: SharedFlow<Boolean>
        get() = _isEntry.asSharedFlow()

    fun auth(authUser: AuthUser) {
        viewModelScope.launch {
            _isEntry.emit(authUseCase(authUser))
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