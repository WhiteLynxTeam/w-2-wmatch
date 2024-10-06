package ru.w_2_wmatch.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.w_2_wmatch.App
import ru.w_2_wmatch.di.modules.AppModule
import ru.w_2_wmatch.di.modules.DataModule
import ru.w_2_wmatch.di.modules.DatabaseModule
import ru.w_2_wmatch.di.modules.DomainModule
import ru.w_2_wmatch.di.modules.MainModule
import ru.w_2_wmatch.di.modules.MappersModule
import ru.w_2_wmatch.di.modules.RemoteModule
import ru.w_2_wmatch.di.modules.SharedPreferencesModule
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        AndroidInjectionModule::class,
        MainModule::class,
        AppModule::class,
        DatabaseModule::class,
        DataModule::class,
        DomainModule::class,
        MappersModule::class,
        RemoteModule::class,
        SharedPreferencesModule::class,
    ]
)

interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun withContext(context: Context): Builder
        fun build(): AppComponent
    }
}

