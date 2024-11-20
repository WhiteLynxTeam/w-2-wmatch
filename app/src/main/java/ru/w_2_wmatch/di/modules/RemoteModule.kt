package ru.w_2_wmatch.di.modules

import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.w_2_wmatch.data.api.TokenApi
import ru.w_2_wmatch.data.api.UserApi
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideTestOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        //Настраиваем таймауты для медленного интернета
        .callTimeout(HALF_MINUTE_FOR_SLOW_INTERNET, TimeUnit.SECONDS)
        .readTimeout(HALF_MINUTE_FOR_SLOW_INTERNET, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        //Указываем базовый URL из констант
        .baseUrl(BASE_URL)
        //Добавляем конвертер
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        //Добавляем кастомный клиент
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)

    @Provides
    @Singleton
    fun provideTokenApi(retrofit: Retrofit): TokenApi = retrofit.create(TokenApi::class.java)

    companion object {
        private const val HALF_MINUTE_FOR_SLOW_INTERNET = 75L
        const val BASE_URL = "https://w2w-backend.onrender.com/"
    }
}