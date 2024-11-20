package ru.w_2_wmatch.domain.irepository

import ru.w_2_wmatch.domain.models.User


interface IUserRepository {
    suspend fun reg(user: User): Boolean
}