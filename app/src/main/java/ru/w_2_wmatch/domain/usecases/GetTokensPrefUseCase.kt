package ru.w_2_wmatch.domain.usecases

import ru.w_2_wmatch.domain.istorage.ITokenStorage
import ru.w_2_wmatch.domain.models.Token

class GetTokensPrefUseCase(
    private val storage: ITokenStorage,
) {
    operator fun invoke(): Token {
        return storage.getAllTokens()
    }
}