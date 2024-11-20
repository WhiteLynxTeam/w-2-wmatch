package ru.w_2_wmatch.data.repository

import ru.w_2_wmatch.data.api.UserApi
import ru.w_2_wmatch.data.dto.user.request.RegisterRequest
import ru.w_2_wmatch.domain.irepository.IUserRepository
import ru.w_2_wmatch.domain.models.User

class UserRepository(
    private val userApi: UserApi
) : IUserRepository {

    override suspend fun reg(user: User): Boolean {
        userApi.reg(mappeUserToUserApi(user))
        return true
    }

    private fun mappeUserToUserApi(
        user: User
    ): RegisterRequest {
        return RegisterRequest(
            fullname = user.fullname,
            email = user.email,
            phone = user.phone,
            password = user.password,
        )
    }
}