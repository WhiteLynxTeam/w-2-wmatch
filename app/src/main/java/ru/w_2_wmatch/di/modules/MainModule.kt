package ru.w_2_wmatch.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.w_2_wmatch.view.MainActivity


@Module
interface MainModule {
    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

}