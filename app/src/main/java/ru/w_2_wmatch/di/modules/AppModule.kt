package ru.w_2_wmatch.di.modules

import dagger.Module
import dagger.Provides
import ru.w_2_wmatch.domain.usecases.AuthUseCase
import ru.w_2_wmatch.domain.usecases.GetQuestionnaireCategoriesApiUseCase
import ru.w_2_wmatch.domain.usecases.GetRefreshTokenPrefUseCase
import ru.w_2_wmatch.domain.usecases.GetTokenApiUseCase
import ru.w_2_wmatch.domain.usecases.RefreshTokenApiUseCase
import ru.w_2_wmatch.domain.usecases.RegisterUseCase
import ru.w_2_wmatch.domain.usecases.SaveBrandPrefUseCase
import ru.w_2_wmatch.view.auth.AuthViewModel
import ru.w_2_wmatch.view.intro.IntroViewModel
import ru.w_2_wmatch.view.questionnaire.brand_position.BrandPositionViewModel
import ru.w_2_wmatch.view.questionnaire.nick_telegram.NickTelegramViewModel
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

    @Provides
    fun provideNickTelegramViewModelFactory(
        saveBrandPrefUseCase: SaveBrandPrefUseCase,
        ) = NickTelegramViewModel.Factory(
        saveBrandPrefUseCase = saveBrandPrefUseCase,
    )

    @Provides
    fun provideBrandPositionViewModelFactory(
        saveBrandPrefUseCase: SaveBrandPrefUseCase,
        getQuestionnaireCategoriesApiUseCase: GetQuestionnaireCategoriesApiUseCase,
        ) = BrandPositionViewModel.Factory(
        saveBrandPrefUseCase = saveBrandPrefUseCase,
        getQuestionnaireCategoriesApiUseCase = getQuestionnaireCategoriesApiUseCase,
    )

}
