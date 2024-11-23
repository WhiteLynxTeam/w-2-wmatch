package ru.w_2_wmatch.domain.istorage

import ru.w_2_wmatch.domain.models.Token

interface ITokenStorage {
    fun getAccessToken(): String
    fun getRefreshToken(): String
    fun saveAllTokens(token: Token)
    fun saveAccessToken(token: String)
    fun saveRefreshToken(token: String)
    fun getAllTokens(): Token

}
