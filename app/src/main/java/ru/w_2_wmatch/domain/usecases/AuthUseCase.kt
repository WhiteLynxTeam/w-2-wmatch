package ru.w_2_wmatch.domain.usecases

import ru.w_2_wmatch.domain.models.AuthUser

class AuthUseCase(
    private val getTokenApiUseCase: GetTokenApiUseCase,
//    private val saveUserToStorage: SaveUserToSharedPrefUseCase
) {
    suspend operator fun invoke(authUser: AuthUser): Boolean {
        val result = getTokenApiUseCase(authUser)
        return result
    }
}