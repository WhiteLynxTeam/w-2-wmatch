package ru.w_2_wmatch.domain.usecases

import ru.w_2_wmatch.domain.istorage.ITokenStorage
import ru.w_2_wmatch.domain.models.Token

class SaveTokenPrefUseCase(
    private val storage: ITokenStorage
) {
    operator fun invoke(token: Token) {
        storage.saveAllTokens(token)
    }
}