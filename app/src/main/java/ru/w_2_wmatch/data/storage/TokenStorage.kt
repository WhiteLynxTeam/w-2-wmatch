package ru.w_2_wmatch.data.storage

import android.content.SharedPreferences
import ru.w_2_wmatch.domain.istorage.ITokenStorage
import ru.w_2_wmatch.domain.models.Token
import javax.inject.Inject

class TokenStorage @Inject constructor(
    private val sharedPreferences: SharedPreferences

) : ITokenStorage {
    override fun getAccessToken(): String {
        return sharedPreferences.getString(ACCESSTOKEN, "") ?: ""
    }

    override fun getRefreshToken(): String {
        return sharedPreferences.getString(REFRESHTOKEN, "") ?: ""
    }

    override fun getAllTokens(): Token {
        val access = sharedPreferences.getString(ACCESSTOKEN, "") ?: ""
        val refresh = sharedPreferences.getString(REFRESHTOKEN, "") ?: ""
        return Token(
            access = access,
            refresh = refresh,
        )
    }

    override fun saveAllTokens(token: Token) {
        sharedPreferences.edit().putString(ACCESSTOKEN, token.access).apply()
        sharedPreferences.edit().putString(REFRESHTOKEN, token.refresh).apply()
    }

    override fun saveAccessToken(token: String) {
        sharedPreferences.edit().putString(ACCESSTOKEN, token).apply()
    }

    override fun saveRefreshToken(token: String) {
        sharedPreferences.edit().putString(ACCESSTOKEN, token).apply()
    }

    companion object {
        private const val ACCESSTOKEN = "accessToken"
        private const val REFRESHTOKEN = "refreshToken"
    }
}
