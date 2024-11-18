package ru.w_2_wmatch.di.modules

import dagger.Module
import dagger.Provides
import ru.w_2_wmatch.domain.irepository.IUserRepository
import ru.w_2_wmatch.domain.usecases.RegisterUseCase
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
}