package ru.w_2_wmatch.view.intro

sealed class IntroState {
    data object Auth: IntroState()
    data object Enter: IntroState()
    data object Loading : IntroState()
    data object Error : IntroState()
}
