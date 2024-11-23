package ru.w_2_wmatch.data.storage

import android.content.SharedPreferences
import ru.w_2_wmatch.domain.istorage.IUserStorage
import ru.w_2_wmatch.domain.models.User
import javax.inject.Inject

class UserStorage @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : IUserStorage {
    override fun getTrial(): Long {
        return sharedPreferences.getLong(IS_TRIAL, 0L)
    }

    override fun setTrial(): Boolean {
        if (sharedPreferences.getLong(IS_TRIAL, 0L) == 0L) {
            sharedPreferences.edit().putLong(IS_TRIAL, System.currentTimeMillis()).apply()
            return true
        }
        return false
    }

    override fun get(): User {
        val fullname = sharedPreferences.getString(FULLNAME, "") ?: ""
        val email = sharedPreferences.getString(EMAIL, "") ?: ""
        val phone = sharedPreferences.getString(PHONE, "") ?: ""
        return User(
            fullname = fullname,
            phone = phone,
            email = email,
        )
    }

    override fun save(user: User) {
        sharedPreferences.edit().putString(FULLNAME, user.fullname).apply()
        sharedPreferences.edit().putString(EMAIL, user.email).apply()
        sharedPreferences.edit().putString(PHONE, user.phone).apply()
    }

    companion object {
        private const val FULLNAME = "fullname"
        private const val EMAIL = "email"
        private const val PHONE = "phone"
        private const val IS_TRIAL = "isTrial"
    }
}
