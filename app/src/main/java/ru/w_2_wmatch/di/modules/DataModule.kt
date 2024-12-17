package ru.w_2_wmatch.di.modules

import android.content.SharedPreferences
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import ru.w_2_wmatch.data.api.QuestionnaireApi
import ru.w_2_wmatch.data.api.TokenApi
import ru.w_2_wmatch.data.api.UserApi
import ru.w_2_wmatch.data.repository.QuestionnaireRepository
import ru.w_2_wmatch.data.repository.TokenRepository
import ru.w_2_wmatch.data.repository.UserRepository
import ru.w_2_wmatch.data.storage.BrandStorage
import ru.w_2_wmatch.data.storage.TokenStorage
import ru.w_2_wmatch.data.storage.UserStorage
import ru.w_2_wmatch.domain.irepository.IQuestionnaireRepository
import ru.w_2_wmatch.domain.irepository.ITokenRepository
import ru.w_2_wmatch.domain.irepository.IUserRepository
import ru.w_2_wmatch.domain.istorage.IBrandStorage
import ru.w_2_wmatch.domain.istorage.ITokenStorage
import ru.w_2_wmatch.domain.istorage.IUserStorage
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideUserRepository(userApi: UserApi): IUserRepository {
        return UserRepository(userApi = userApi)
    }

    @Provides
    @Singleton
    fun provideTokenRepository(
        tokenApi: TokenApi,
        tokenStorage: ITokenStorage,
    ): ITokenRepository {
        return TokenRepository(
            tokenApi = tokenApi,
            tokenStorage = tokenStorage,
        )
    }

    @Provides
    @Singleton
    fun provideTokenStorage(
        sharedPreferences: SharedPreferences,
    ): ITokenStorage {
        return TokenStorage(
            sharedPreferences = sharedPreferences,
        )
    }

//    @Provides
//    @Singleton
//    fun provideUserStorage(
//        sharedPreferences: SharedPreferences,
//    ): IUserStorage {
//        return UserStorage(
//            sharedPreferences = sharedPreferences,
//        )
//    }

    @Provides
    @Singleton
    fun provideBrandStorage(
        sharedPreferences: SharedPreferences,
        gson: Gson,
    ): IBrandStorage {
        return BrandStorage(
            sharedPreferences = sharedPreferences,
            gson = gson
        )
    }

    @Provides
    @Singleton
    fun provideQuestionnaireRepository(
        questionnaireApi: QuestionnaireApi,
    ): IQuestionnaireRepository {
        return QuestionnaireRepository(
            questionnaireApi = questionnaireApi,
        )
    }
}