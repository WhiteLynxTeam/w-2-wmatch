package ru.w_2_wmatch.di.modules

import dagger.Module
import dagger.Provides
import ru.w_2_wmatch.data.api.TokenApi
import ru.w_2_wmatch.data.api.UserApi
import ru.w_2_wmatch.data.repository.TokenRepository
import ru.w_2_wmatch.data.repository.UserRepository
import ru.w_2_wmatch.domain.irepository.ITokenRepository
import ru.w_2_wmatch.domain.irepository.IUserRepository
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
    fun provideUserRepository(tokenApi: TokenApi) : ITokenRepository {
        return TokenRepository(tokenApi = tokenApi)
    }
}