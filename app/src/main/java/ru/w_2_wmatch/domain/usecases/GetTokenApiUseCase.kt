package ru.w_2_wmatch.domain.usecases

import ru.w_2_wmatch.domain.irepository.ITokenRepository
import ru.w_2_wmatch.domain.models.AuthUser

class GetTokenApiUseCase(
    private val repository: ITokenRepository,
    private val saveTokenPrefUseCase: SaveTokenPrefUseCase,
) {
    suspend operator fun invoke(authUser: AuthUser): Boolean {
        val result = repository.getToken(authUser)

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