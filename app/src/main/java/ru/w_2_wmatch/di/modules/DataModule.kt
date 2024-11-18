package ru.w_2_wmatch.di.modules

import dagger.Module
import dagger.Provides
import ru.w_2_wmatch.data.api.UserApi
import ru.w_2_wmatch.data.repository.UserRepository
import ru.w_2_wmatch.domain.irepository.IUserRepository
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideUserRepository(userApi: UserApi) : IUserRepository {
        return UserRepository(userApi = userApi)
    }
}