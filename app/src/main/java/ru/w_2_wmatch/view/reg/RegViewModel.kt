package ru.w_2_wmatch.view.reg

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.w_2_wmatch.domain.AppState
import ru.w_2_wmatch.domain.models.User
import ru.w_2_wmatch.domain.usecases.RegisterUseCase

class RegViewModel(private val registerUseCase: RegisterUseCase) : ViewModel() {
    private val _appStateFlow = MutableStateFlow<AppState>(AppState.None)
    val appStateFlow: StateFlow<AppState> = _appStateFlow

    fun reg(user: User) {
        viewModelScope.launch {
            _appStateFlow.emit(AppState.Loading)
            _appStateFlow.emit(AppState.Success(registerUseCase(user)))
        }
    }

    class Factory(
        private val registerUseCase: RegisterUseCase
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RegViewModel::class.java)) {
                return RegViewModel(
                    registerUseCase = registerUseCase,
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}