package ru.w_2_wmatch.data.storage

import android.content.SharedPreferences
import ru.w_2_wmatch.domain.istorage.IBrandStorage
import ru.w_2_wmatch.domain.models.Brand
import javax.inject.Inject

class BrandStorage @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : IBrandStorage {
    override fun save(brand: Brand) {
        sharedPreferences.edit().putString(TG_NICKNAME, brand.tg_nickname).apply()
        sharedPreferences.edit().putInt(CITY_ID, brand.city_id).apply()
        sharedPreferences.edit().putString(CITY_NAME, brand.city_name).apply()
        sharedPreferences.edit().putString(NAME_BRAND, brand.name_brand).apply()
        sharedPreferences.edit().putString(POSITION_IN_BRAND, brand.position_in_brand).apply()
        sharedPreferences.edit().putString(SITE_URL, brand.site_url).apply()
        sharedPreferences.edit().putString(INST_URL, brand.inst_url).apply()
        sharedPreferences.edit().putString(VK_URL, brand.vk_url).apply()
        sharedPreferences.edit().putString(TG_URL, brand.tg_url).apply()
        sharedPreferences.edit().putString(WB_URL, brand.wb_url).apply()
        sharedPreferences.edit().putString(LAMODA_URL, brand.lamoda_url).apply()
    }

    override fun get(): Brand {
        val tg_nickname = sharedPreferences.getString(TG_NICKNAME, "") ?: ""
        val city_id = sharedPreferences.getInt(CITY_ID, -1)
        val city_name = sharedPreferences.getString(CITY_NAME, "") ?: ""
        val name_brand = sharedPreferences.getString(NAME_BRAND, "") ?: ""
        val position_in_brand = sharedPreferences.getString(POSITION_IN_BRAND, "") ?: ""
        val site_url = sharedPreferences.getString(SITE_URL, "") ?: ""
        val inst_url = sharedPreferences.getString(INST_URL, "") ?: ""
        val vk_url = sharedPreferences.getString(VK_URL, "") ?: ""
        val tg_url = sharedPreferences.getString(TG_URL, "") ?: ""
        val wb_url = sharedPreferences.getString(WB_URL, "") ?: ""
        val lamoda_url = sharedPreferences.getString(LAMODA_URL, "") ?: ""
        return Brand(
            tg_nickname = tg_nickname,
            city_id = city_id,
            city_name = city_name,
            name_brand = name_brand,
            position_in_brand = position_in_brand,
            site_url = site_url,
            inst_url = inst_url,
            vk_url = vk_url,
            tg_url = tg_url,
            wb_url = wb_url,
            lamoda_url = lamoda_url,
        )
    }

    companion object {
        private const val TG_NICKNAME = "tg_nickname"
        private const val CITY_ID = "city_id"
        private const val CITY_NAME = "city_name"
        private const val BLOGS_LIST = "blogs_list"
        private const val NAME_BRAND = "name_brand"
        private const val POSITION_IN_BRAND = "position_in_brand"
        private const val CATEGORY = "category"
        private const val SITE_URL = "site_url"
        private const val INST_URL = "inst_url"
        private const val VK_URL = "vk_url"
        private const val TG_URL = "tg_url"
        private const val WB_URL = "wb_url"
        private const val LAMODA_URL = "lamoda_url"
    }
}
