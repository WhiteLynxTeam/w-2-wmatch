package ru.w_2_wmatch

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.w_2_wmatch.di.DaggerAppComponent

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<App> =
        DaggerAppComponent.builder().withContext(applicationContext).build()
}