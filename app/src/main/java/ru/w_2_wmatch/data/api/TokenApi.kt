package ru.w_2_wmatch.data.api

import retrofit2.http.Body
import retrofit2.http.POST
import ru.w_2_wmatch.data.dto.token.request.CreateTokenRequest
import ru.w_2_wmatch.data.dto.token.request.RefreshTokenRequest
import ru.w_2_wmatch.data.dto.token.response.CreateTokenResponse

interface TokenApi {
    @POST("/auth/jwt/create/")
    suspend fun get(@Body createTokenRequest: CreateTokenRequest): Result<CreateTokenResponse>

    @POST("/auth/jwt/refresh/")
    suspend fun refresh(@Body refreshToken: RefreshTokenRequest): Result<CreateTokenResponse>
}
