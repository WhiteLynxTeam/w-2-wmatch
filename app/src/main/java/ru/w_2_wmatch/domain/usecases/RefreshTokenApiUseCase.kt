package ru.w_2_wmatch.domain.usecases

import ru.w_2_wmatch.domain.irepository.ITokenRepository

class RefreshTokenApiUseCase(
    private val repository: ITokenRepository,
    private val saveTokenPrefUseCase: SaveTokenPrefUseCase,
) {
    suspend operator fun invoke(refreshToken: String): Boolean {
        val result = repository.refreshToken(refreshToken)

        if (result.isSuccess) {
            val token = result.getOrNull()
            if (token != null) {
                saveTokenPrefUseCase(token)
                return true
            }
        }
        return false
    }
}