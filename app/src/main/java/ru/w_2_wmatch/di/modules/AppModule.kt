package ru.w_2_wmatch.di.modules

import dagger.Module
import dagger.Provides
import ru.w_2_wmatch.domain.usecases.GetTokenApiUseCase
import ru.w_2_wmatch.domain.usecases.RegisterUseCase
import ru.w_2_wmatch.view.auth.AuthViewModel
import ru.w_2_wmatch.view.reg.RegViewModel

@Module
class AppModule() {
    @Provides
    fun provideRegisterViewModelFactory(
        registerUseCase: RegisterUseCase,

        ) = RegViewModel.Factory(
        registerUseCase = registerUseCase
    )
    @Provides
    fun provideAuthViewModelFactory(
        getTokenApiUseCase: GetTokenApiUseCase,

        ) = AuthViewModel.Factory(
        getTokenApiUseCase = getTokenApiUseCase,
    )

}
