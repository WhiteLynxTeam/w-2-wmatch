package ru.w_2_wmatch.di.modules

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import ru.w_2_wmatch.data.api.TokenApi
import ru.w_2_wmatch.data.api.UserApi
import ru.w_2_wmatch.data.repository.TokenRepository
import ru.w_2_wmatch.data.repository.UserRepository
import ru.w_2_wmatch.data.storage.TokenStorage
import ru.w_2_wmatch.data.storage.UserStorage
import ru.w_2_wmatch.domain.irepository.ITokenRepository
import ru.w_2_wmatch.domain.irepository.IUserRepository
import ru.w_2_wmatch.domain.istorage.ITokenStorage
import ru.w_2_wmatch.domain.istorage.IUserStorage
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideUserRepository(userApi: UserApi) : IUserRepository {
        return UserRepository(userApi = userApi)
    }

    @Provides
    @Singleton
    fun provideTokenRepository(
        tokenApi: TokenApi,
        tokenStorage: TokenStorage,
        ) : ITokenRepository {
        return TokenRepository(
            tokenApi = tokenApi,
            tokenStorage =  tokenStorage,
            )
    }
    @Provides
    @Singleton
    fun provideTokenStorage(
        sharedPreferences: SharedPreferences,
        ) : ITokenStorage {
        return TokenStorage(
            sharedPreferences = sharedPreferences,
            )
    }
    @Provides
    @Singleton
    fun provideUserStorage(
        sharedPreferences: SharedPreferences,
        ) : IUserStorage {
        return UserStorage(
            sharedPreferences = sharedPreferences,
            )
    }
}