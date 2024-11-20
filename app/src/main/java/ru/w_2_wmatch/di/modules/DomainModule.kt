package ru.w_2_wmatch.di.modules

import dagger.Module
import dagger.Provides
import ru.w_2_wmatch.domain.irepository.ITokenRepository
import ru.w_2_wmatch.domain.irepository.IUserRepository
import ru.w_2_wmatch.domain.istorage.ITokenStorage
import ru.w_2_wmatch.domain.usecases.GetTokenApiUseCase
import ru.w_2_wmatch.domain.usecases.RegisterUseCase
import ru.w_2_wmatch.domain.usecases.SaveTokenPrefUseCase
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideRegisterUser(
        repository: IUserRepository,
    ): RegisterUseCase {
        return RegisterUseCase(repository = repository)
    }

    @Singleton
    @Provides
    fun provideGetTokenApiUseCase(
        repository: ITokenRepository,
        saveTokenPrefUseCase: SaveTokenPrefUseCase,

    ): GetTokenApiUseCase {
        return GetTokenApiUseCase(
            repository = repository,
            saveTokenPrefUseCase = saveTokenPrefUseCase,
        )
    }

    @Singleton
    @Provides
    fun provideSaveTokenPrefUseCase(
        storage: ITokenStorage
    ): SaveTokenPrefUseCase {
        return SaveTokenPrefUseCase(storage = storage)
    }

}