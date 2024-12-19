package ru.w_2_wmatch.di.modules

import dagger.Module
import dagger.Provides
import ru.w_2_wmatch.domain.irepository.IQuestionnaireRepository
import ru.w_2_wmatch.domain.irepository.ITokenRepository
import ru.w_2_wmatch.domain.irepository.IUserRepository
import ru.w_2_wmatch.domain.istorage.IBrandStorage
import ru.w_2_wmatch.domain.istorage.ITokenStorage
import ru.w_2_wmatch.domain.usecases.AuthUseCase
import ru.w_2_wmatch.domain.usecases.GetQuestionnaireCategoriesApiUseCase
import ru.w_2_wmatch.domain.usecases.GetRefreshTokenPrefUseCase
import ru.w_2_wmatch.domain.usecases.GetTokenApiUseCase
import ru.w_2_wmatch.domain.usecases.GetTokensPrefUseCase
import ru.w_2_wmatch.domain.usecases.RefreshTokenApiUseCase
import ru.w_2_wmatch.domain.usecases.RegisterUseCase
import ru.w_2_wmatch.domain.usecases.SaveBrandPrefUseCase
import ru.w_2_wmatch.domain.usecases.SaveTokenPrefUseCase
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideRegisterUseCase(
        repository: IUserRepository,
    ): RegisterUseCase {
        return RegisterUseCase(repository = repository)
    }

    @Singleton
    @Provides
    fun provideAuthUseCase(
        getTokenApiUseCase: GetTokenApiUseCase,
    ): AuthUseCase {
        return AuthUseCase(getTokenApiUseCase = getTokenApiUseCase)
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

    @Singleton
    @Provides
    fun provideGetTokenPrefUseCase(
        storage: ITokenStorage
    ): GetRefreshTokenPrefUseCase {
        return GetRefreshTokenPrefUseCase(storage = storage)
    }

    @Singleton
    @Provides
    fun provideRefreshTokenApiUseCase(
        repository: ITokenRepository,
        saveTokenPrefUseCase: SaveTokenPrefUseCase,
    ): RefreshTokenApiUseCase {
        return RefreshTokenApiUseCase(
            repository = repository,
            saveTokenPrefUseCase = saveTokenPrefUseCase,
        )
    }

    @Singleton
    @Provides
    fun provideSaveBrandPrefUseCase(
        storage: IBrandStorage
    ): SaveBrandPrefUseCase {
        return SaveBrandPrefUseCase(
            storage = storage,
        )
    }

    @Singleton
    @Provides
    fun provideGetTokensPrefUseCase(
        storage: ITokenStorage
    ): GetTokensPrefUseCase {
        return GetTokensPrefUseCase(
            storage = storage,
        )
    }

    @Singleton
    @Provides
    fun provideGetQuestionnaireCategoriesApiUseCase(
        repository: IQuestionnaireRepository,
        getTokensPrefUseCase: GetTokensPrefUseCase,
        refreshTokenApiUseCase: RefreshTokenApiUseCase,
    ): GetQuestionnaireCategoriesApiUseCase {
        return GetQuestionnaireCategoriesApiUseCase(
            repository = repository,
            getTokensPrefUseCase = getTokensPrefUseCase,
            refreshTokenApiUseCase = refreshTokenApiUseCase,
        )
    }

}