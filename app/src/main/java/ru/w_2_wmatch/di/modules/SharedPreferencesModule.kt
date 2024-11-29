package ru.w_2_wmatch.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferencesModule {
    @Provides
    @Singleton
    fun provideSharedPref(context: Context): SharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideGson() = Gson()

    companion object {
        const val SHARED_PREFERENCES = "w2w_match_settings"
    }
}