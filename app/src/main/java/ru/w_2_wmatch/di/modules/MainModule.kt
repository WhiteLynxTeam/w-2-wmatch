package ru.w_2_wmatch.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.w_2_wmatch.view.activity.MainActivity
import ru.w_2_wmatch.view.auth.AuthFragment
import ru.w_2_wmatch.view.intro.IntroFragment
import ru.w_2_wmatch.view.questionnaire.brand_position.BrandPositionFragment
import ru.w_2_wmatch.view.questionnaire.brands_mission.BrandsMissionFragment
import ru.w_2_wmatch.view.questionnaire.key_brand_values.KeyBrandValuesFragment
import ru.w_2_wmatch.view.questionnaire.nick_telegram.NickTelegramFragment
import ru.w_2_wmatch.view.questionnaire.offline_space.OfflineSpaceFragment
import ru.w_2_wmatch.view.questionnaire.social_network_link.SocialNetworkLinkFragment
import ru.w_2_wmatch.view.questionnaire.target_audience.TargetAudienceFragment
import ru.w_2_wmatch.view.reg.RegFragment
import ru.w_2_wmatch.view.reg.choosing_to_fill_questionnaire.ChoosingToFillQuestionnaireFragment

@Module
interface MainModule {
    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindIntroFragment(): IntroFragment

    @ContributesAndroidInjector
    fun bindAuthFragment(): AuthFragment

    @ContributesAndroidInjector
    fun bindRegFragment(): RegFragment

    @ContributesAndroidInjector
    fun bindNickTelegram(): NickTelegramFragment

    @ContributesAndroidInjector
    fun bindBrandPosition(): BrandPositionFragment

    @ContributesAndroidInjector
    fun bindSocialNetworkLink(): SocialNetworkLinkFragment

    @ContributesAndroidInjector
    fun bindKeyBrandValuesFragment(): KeyBrandValuesFragment

    @ContributesAndroidInjector
    fun bindTargetAudienceFragment(): TargetAudienceFragment

    @ContributesAndroidInjector
    fun bindChoosingToFillQuestionnaireFragment(): ChoosingToFillQuestionnaireFragment

    @ContributesAndroidInjector
    fun bindBrandsMissionFragment(): BrandsMissionFragment

    @ContributesAndroidInjector
    fun bindOfflineSpaceFragment(): OfflineSpaceFragment
}