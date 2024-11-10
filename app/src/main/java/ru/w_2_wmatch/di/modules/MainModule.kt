package ru.w_2_wmatch.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.w_2_wmatch.view.MainActivity
import ru.w_2_wmatch.view.auth.AuthFragment
import ru.w_2_wmatch.view.intro.IntroFragment
import ru.w_2_wmatch.view.questionnaire.QuestionnaireFragment
import ru.w_2_wmatch.view.questionnaire.brand_position.BrandPositionFragment
import ru.w_2_wmatch.view.questionnaire.key_brand_values.KeyBrandValuesFragment
import ru.w_2_wmatch.view.questionnaire.nick_telegram.NickTelegramFragment
import ru.w_2_wmatch.view.questionnaire.social_network_link.SocialNetworkLinkFragment

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

    @ContributesAndroidInjector
    fun bindBrandPosition(): BrandPositionFragment

    @ContributesAndroidInjector
    fun bindSocialNetworkLink(): SocialNetworkLinkFragment

    @ContributesAndroidInjector
    fun bindKeyBrandValuesFragment(): KeyBrandValuesFragment

}