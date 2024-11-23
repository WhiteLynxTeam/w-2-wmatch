package ru.w_2_wmatch.domain.istorage

import ru.w_2_wmatch.domain.models.User

interface IUserStorage {
    fun getTrial(): Long
    fun setTrial(): Boolean
    fun save(user: User)
    fun get(): User
}
