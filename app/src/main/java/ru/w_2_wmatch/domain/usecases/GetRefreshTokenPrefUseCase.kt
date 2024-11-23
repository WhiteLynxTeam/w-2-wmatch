package ru.w_2_wmatch.domain.usecases

import ru.w_2_wmatch.domain.istorage.ITokenStorage

class GetRefreshTokenPrefUseCase(
    private val storage: ITokenStorage,
) {
    operator fun invoke(): String {
        return storage.getRefreshToken()
    }
}