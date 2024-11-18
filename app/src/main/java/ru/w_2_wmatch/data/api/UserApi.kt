package ru.w_2_wmatch.data.api

import retrofit2.http.Body
import retrofit2.http.POST
import ru.w_2_wmatch.data.dto.user.request.RegisterRequest
import ru.w_2_wmatch.data.dto.user.response.RegisterResponse

interface UserApi {
    @POST("auth/users/")
    suspend fun reg(@Body registerRequest: RegisterRequest): Result<RegisterResponse>

//    @POST("/login/")
//    suspend fun login(@Body loginRequest: LoginRequest): Result<LoginResponse>
//
//    @GET("/player/")
//    suspend fun getPlayer(
//        @Header("Authorization") token: String,
//    ): Result<PlayerResponse>
//
//    @PUT("/player/")
//    suspend fun updatePlayer(
//        @Header("Authorization") token: String,
//        @Body persRequest: PersRequest
//    ): Result<PlayerResponse>

}
