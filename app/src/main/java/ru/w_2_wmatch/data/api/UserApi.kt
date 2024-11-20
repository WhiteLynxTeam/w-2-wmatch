package ru.w_2_wmatch.data.api

import retrofit2.http.Body
import retrofit2.http.POST
import ru.w_2_wmatch.data.dto.user.request.RegisterUserRequest
import ru.w_2_wmatch.data.dto.user.response.RegisterUserResponse

interface UserApi {
    @POST("auth/users/")
    suspend fun reg(@Body registerUserRequest: RegisterUserRequest): Result<RegisterUserResponse>
}
