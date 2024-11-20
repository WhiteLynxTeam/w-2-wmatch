package ru.w_2_wmatch.view.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.w_2_wmatch.domain.models.AuthUser
import ru.w_2_wmatch.domain.models.User
import ru.w_2_wmatch.domain.usecases.GetTokenApiUseCase

class AuthViewModel(private val getTokenApiUseCase: GetTokenApiUseCase) : ViewModel() {

    private var _isEntry = MutableSharedFlow<Boolean>()
    val isEntry: SharedFlow<Boolean>
        get() = _isEntry.asSharedFlow()

    fun auth(authUser: AuthUser) {
        viewModelScope.launch {
            _isEntry.emit(getTokenApiUseCase(authUser))
        }
    }
    class Factory(
        private val getTokenApiUseCase: GetTokenApiUseCase
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
                return AuthViewModel(
                    getTokenApiUseCase = getTokenApiUseCase,
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}