package ru.w_2_wmatch.view.intro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.w_2_wmatch.domain.usecases.GetRefreshTokenPrefUseCase
import ru.w_2_wmatch.domain.usecases.RefreshTokenApiUseCase

class IntroViewModel(
    private val getRefreshTokenPrefUseCase: GetRefreshTokenPrefUseCase,
    private val refreshTokenApiUseCase: RefreshTokenApiUseCase,
    ) : ViewModel() {
    private val _introStateFlow = MutableStateFlow<IntroState>(IntroState.Loading)
    val introStateFlow: StateFlow<IntroState> = _introStateFlow

    init {
        auth()
    }

    fun auth() {
        viewModelScope.launch {
            val refreshToken = getRefreshTokenPrefUseCase()
            if (refreshToken.isEmpty()) {
                _introStateFlow.emit(IntroState.Auth)
            } else {
                if (refreshTokenApiUseCase(refreshToken)) {
                    _introStateFlow.emit(IntroState.Enter)
                } else {
                    _introStateFlow.emit(IntroState.Error)
                }
            }
        }
    }

    class Factory(
        private val getRefreshTokenPrefUseCase: GetRefreshTokenPrefUseCase,
        private val refreshTokenApiUseCase: RefreshTokenApiUseCase,
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(IntroViewModel::class.java)) {
                return IntroViewModel(
                    getRefreshTokenPrefUseCase = getRefreshTokenPrefUseCase,
                    refreshTokenApiUseCase = refreshTokenApiUseCase,
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }}