package ru.w_2_wmatch.domain.usecases

import ru.w_2_wmatch.domain.istorage.ITokenStorage

class GetTokenPrefUseCase(
    private val storage: ITokenStorage,
) {
    operator fun invoke() {
        val accessToken = storage.getAccessToken()
        if (accessToken.isEmpty()) {

        } else {

        }
    }
}