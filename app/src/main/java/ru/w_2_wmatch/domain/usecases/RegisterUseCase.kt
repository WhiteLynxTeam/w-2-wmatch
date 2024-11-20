package ru.w_2_wmatch.domain.usecases

import ru.w_2_wmatch.domain.irepository.IUserRepository
import ru.w_2_wmatch.domain.models.User

class RegisterUseCase(
    private val repository: IUserRepository,
//    private val saveUserToStorage: SaveUserToSharedPrefUseCase
) {
    suspend operator fun invoke(user: User): Boolean {
        val result = repository.reg(user)
        return result
    }
}