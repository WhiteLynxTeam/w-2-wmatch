package ru.w_2_wmatch.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.w_2_wmatch.view.MainActivity
import ru.w_2_wmatch.view.auth.AuthFragment
import ru.w_2_wmatch.view.intro.IntroFragment
import ru.w_2_wmatch.view.questionnaire.QuestionnaireFragment
import ru.w_2_wmatch.view.questionnaire.nick_telegram.NickTelegramFragment

@Module
interface MainModule {
    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindIntroFragment(): IntroFragment

    @ContributesAndroidInjector
    fun bindAuthFragment(): AuthFragment

    @ContributesAndroidInjector
    fun bindQuestionnaireFragment(): QuestionnaireFragment

    @ContributesAndroidInjector
    fun bindNickTelegram(): NickTelegramFragment

}