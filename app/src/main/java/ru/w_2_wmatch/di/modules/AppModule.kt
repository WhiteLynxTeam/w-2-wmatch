package ru.w_2_wmatch.di.modules

import dagger.Module
import dagger.Provides
import ru.w_2_wmatch.domain.usecases.AuthUseCase
import ru.w_2_wmatch.domain.usecases.GetRefreshTokenPrefUseCase
import ru.w_2_wmatch.domain.usecases.GetTokenApiUseCase
import ru.w_2_wmatch.domain.usecases.RefreshTokenApiUseCase
import ru.w_2_wmatch.domain.usecases.RegisterUseCase
import ru.w_2_wmatch.view.auth.AuthViewModel
import ru.w_2_wmatch.view.intro.IntroViewModel
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
        authUseCase: AuthUseCase,
        ) = AuthViewModel.Factory(
        authUseCase = authUseCase,
    )

    @Provides
    fun provideIntroViewModelFactory(
        getRefreshTokenPrefUseCase: GetRefreshTokenPrefUseCase,
        refreshTokenApiUseCase: RefreshTokenApiUseCase,
        ) = IntroViewModel.Factory(
        getRefreshTokenPrefUseCase = getRefreshTokenPrefUseCase,
        refreshTokenApiUseCase = refreshTokenApiUseCase,
    )

}
