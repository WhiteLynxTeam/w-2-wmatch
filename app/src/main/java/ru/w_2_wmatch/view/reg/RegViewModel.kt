package ru.w_2_wmatch.view.reg

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.w_2_wmatch.domain.models.User
import ru.w_2_wmatch.domain.usecases.RegisterUseCase

class RegViewModel(private val registerUseCase: RegisterUseCase) : ViewModel() {
    private var _isEntry = MutableSharedFlow<Boolean>()
    val isEntry: SharedFlow<Boolean>
        get() = _isEntry.asSharedFlow()

    fun reg(user: User) {
        viewModelScope.launch {
            _isEntry.emit(registerUseCase(user))
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