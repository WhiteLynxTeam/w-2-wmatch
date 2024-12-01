package ru.w_2_wmatch.view.main.match_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentMatchPageBinding
import ru.w_2_wmatch.domain.models.LikedUsers
import ru.w_2_wmatch.domain.models.MyLikes
import ru.w_2_wmatch.domain.models.RecommendedBrands
import ru.w_2_wmatch.view.base.BaseFragment

class MatchPageFragment : BaseFragment() {

    private var _binding: FragmentMatchPageBinding? = null
    private val binding get() = _binding!!
    private lateinit var likedUsersAdapter: LikedUsersAdapter
    private lateinit var recommendedBrandsAdapter: RecommendedBrandsAdapter
    private lateinit var myLikesAdapter: MyLikesAdapter
    private lateinit var myMatchesAdapter: MyLikesAdapter

    private lateinit var viewModel: MatchPageViewModel

    private val users = listOf(
        LikedUsers(R.drawable.img_profile, "Photo 1"),
        LikedUsers(R.drawable.img_profile, "Photo 2"),
        LikedUsers(R.drawable.img_profile, "Photo 3"),
        LikedUsers(R.drawable.img_profile, "Photo 4")
    )

    private val brands = listOf(
        RecommendedBrands(
            R.drawable.img_communiti1,
            "Barbara",
            R.drawable.ic_geo_brand,
            "Москва",
            R.drawable.ic_subscribers,
            "1000"
        ),
        RecommendedBrands(
            R.drawable.img_communiti1,
            "Barbara",
            R.drawable.ic_geo_brand,
            "Москва",
            R.drawable.ic_subscribers,
            "1000"
        ),
        RecommendedBrands(
            R.drawable.img_communiti1,
            "Barbara",
            R.drawable.ic_geo_brand,
            "Москва",
            R.drawable.ic_subscribers,
            "1000"
        ),
        RecommendedBrands(
            R.drawable.img_communiti1,
            "Barbara",
            R.drawable.ic_geo_brand,
            "Москва",
            R.drawable.ic_subscribers,
            "1000"
        )
    )

    private val myLikes = listOf(
        MyLikes(
            R.drawable.the_banner,
            "The Annex",
            "Роскошь в нашем прочтении - ДНК Нашего Бренда",
            R.drawable.img_profile,
            "Юлия Зильверг",
            R.drawable.ic_geo_brand_white,
            "Москва",
            R.drawable.ic_subscribers_white,
            "0 - 1000"
        ),
        MyLikes(
            R.drawable.the_banner,
            "The Annex",
            "Роскошь в нашем прочтении - ДНК Нашего Бренда",
            R.drawable.img_profile,
            "Юлия Зильверг",
            R.drawable.ic_geo_brand_white,
            "Москва",
            R.drawable.ic_subscribers_white,
            "0 - 1000"
        ),
        MyLikes(
            R.drawable.the_banner,
            "The Annex",
            "Роскошь в нашем прочтении - ДНК Нашего Бренда",
            R.drawable.img_profile,
            "Юлия Зильверг",
            R.drawable.ic_geo_brand_white,
            "Москва",
            R.drawable.ic_subscribers_white,
            "0 - 1000"
        ),
        MyLikes(
            R.drawable.the_banner,
            "The Annex",
            "Роскошь в нашем прочтении - ДНК Нашего Бренда",
            R.drawable.img_profile,
            "Юлия Зильверг",
            R.drawable.ic_geo_brand_white,
            "Москва",
            R.drawable.ic_subscribers_white,
            "0 - 1000"
        )
    )

    private val myMatches = listOf(
        MyLikes(
            R.drawable.the_banner2,
            "IKATIQUE",
            "Роскошь в нашем прочтении - ДНК Нашего Бренда",
            R.drawable.img_profile,
            "Юлия Зильверг",
            R.drawable.ic_geo_brand_white,
            "Москва",
            R.drawable.ic_subscribers_white,
            "0 - 1000"
        ),
        MyLikes(
            R.drawable.the_banner2,
            "IKATIQUE",
            "Роскошь в нашем прочтении - ДНК Нашего Бренда",
            R.drawable.img_profile,
            "Юлия Зильверг",
            R.drawable.ic_geo_brand_white,
            "Москва",
            R.drawable.ic_subscribers_white,
            "0 - 1000"
        ),
        MyLikes(
            R.drawable.the_banner2,
            "IKATIQUE",
            "Роскошь в нашем прочтении - ДНК Нашего Бренда",
            R.drawable.img_profile,
            "Юлия Зильверг",
            R.drawable.ic_geo_brand_white,
            "Москва",
            R.drawable.ic_subscribers_white,
            "0 - 1000"
        ),
        MyLikes(
            R.drawable.the_banner2,
            "IKATIQUE",
            "Роскошь в нашем прочтении - ДНК Нашего Бренда",
            R.drawable.img_profile,
            "Юлия Зильверг",
            R.drawable.ic_geo_brand_white,
            "Москва",
            R.drawable.ic_subscribers_white,
            "0 - 1000"
        )
    )

    val periods =
        listOf("За выбранный период", "Период 1", "Период 2", "Период 3", "Период 4", "Период 5")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMatchPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        likedUsersAdapter = LikedUsersAdapter(users)
        binding.rcLike.adapter = likedUsersAdapter

        recommendedBrandsAdapter = RecommendedBrandsAdapter(brands)
        binding.rcRecommendedBrands.adapter = recommendedBrandsAdapter

        myLikesAdapter = MyLikesAdapter(myLikes)
        binding.rcMyLikes.adapter = myLikesAdapter

        myMatchesAdapter = MyLikesAdapter(myMatches)
        binding.rcMyMatches.adapter = myMatchesAdapter

        val spinnerAdapter = ArrayAdapter(
            requireContext(),
            R.layout.custom_spinner_item, // Указываем кастомный макет
            periods
        )

        // Применяем адаптер к Spinner
        binding.tvPeriod.adapter = spinnerAdapter

        // Обработка выбора элемента
        binding.tvPeriod.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                Toast.makeText(requireContext(), "Вы выбрали: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Когда ничего не выбрано
            }
        }
    }
}
