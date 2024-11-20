package ru.w_2_wmatch.domain.irepository

import ru.w_2_wmatch.domain.models.AuthUser
import ru.w_2_wmatch.domain.models.Token

interface ITokenRepository {
    suspend fun create(authUser: AuthUser): Result<Token>
}