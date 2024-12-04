package ru.w_2_wmatch.view.main.mane

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentPageManeBinding
import ru.w_2_wmatch.domain.models.Community
import ru.w_2_wmatch.domain.models.Media
import ru.w_2_wmatch.domain.models.NewsEducation
import ru.w_2_wmatch.view.base.BaseFragment
import ru.w_2_wmatch.view.main.mane.adapters.CommunityAdapter
import ru.w_2_wmatch.view.main.mane.adapters.MediaAdapter
import ru.w_2_wmatch.view.main.mane.adapters.NewsEducationAdapter

class PageManeFragment : BaseFragment() {
    private var _binding: FragmentPageManeBinding? = null
    private val binding get() = _binding!!

    private lateinit var communityAdapter: CommunityAdapter
    private lateinit var mediaAdapter: MediaAdapter
    private lateinit var newsEducationAdapter: NewsEducationAdapter

    private lateinit var viewModel: PageManeViewModel

    private val community = listOf(
        Community(
            img = R.drawable.img_communiti,
            title = "Как создать первую коллабу?",
            description = "Мы хотим подарить женщинам ВРЕМЯ, которое они ежедневно тратят на выбор подходящей одежды"
        ),
        Community(
            img = R.drawable.img_communiti,
            title = "Как создать первую коллабу?",
            description = "Мы хотим подарить женщинам ВРЕМЯ, которое они ежедневно тратят на выбор подходящей одежды"
        ),
        Community(
            img = R.drawable.img_communiti,
            title = "Как создать первую коллабу?",
            description = "Мы хотим подарить женщинам ВРЕМЯ, которое они ежедневно тратят на выбор подходящей одежды"
        ),
        Community(
            img = R.drawable.img_communiti,
            title = "Как создать первую коллабу?",
            description = "Мы хотим подарить женщинам ВРЕМЯ, которое они ежедневно тратят на выбор подходящей одежды"
        ),
    )

    private val media = listOf(
        Media(
            img = R.drawable.img_media1,
            title = "The Wellnus & Sarro",
            description = "Познакомьтесь c будущими партнерам"
        ),
        Media(
            img = R.drawable.img_media2,
            title = "The Wellnus & Sarro",
            description = "Познакомьтесь c будущими партнерам"
        ),
        Media(
            img = R.drawable.img_media1,
            title = "The Wellnus & Sarro",
            description = "Познакомьтесь c будущими партнерам"
        ),
        Media(
            img = R.drawable.img_media2,
            title = "The Wellnus & Sarro",
            description = "Познакомьтесь c будущими партнерам"
        ),
    )
    private val news = listOf(
        NewsEducation(
            img = R.drawable.img_news1,
            title = "The Wellnus & Sarro",
            description = "Познакомьтесь c будущими партнерам"
        ),
        NewsEducation(
            img = R.drawable.img_news1,
            title = "The Wellnus & Sarro",
            description = "Познакомьтесь c будущими партнерам"
        ),
        NewsEducation(
            img = R.drawable.img_news1,
            title = "The Wellnus & Sarro",
            description = "Познакомьтесь c будущими партнерам"
        ),
    )
    private val education = listOf(
        NewsEducation(
            img = R.drawable.img_education1,
            title = "The Wellnus & Sarro",
            description = "Познакомьтесь c будущими партнерам"
        ),
        NewsEducation(
            img = R.drawable.img_education1,
            title = "The Wellnus & Sarro",
            description = "Познакомьтесь c будущими партнерам"
        ),
        NewsEducation(
            img = R.drawable.img_education1,
            title = "The Wellnus & Sarro",
            description = "Познакомьтесь c будущими партнерам"
        ),
    )

    val periods = listOf(
        "За выбранный период", "Период 1", "Период 2", "Период 3", "Период 4", "Период 5"
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listener?.apply {
            onTitleTextChange("Привет")
            hideBackArrow()
            showBackTitle()
            showAvatar()
            showNotification()
        }

        _binding = FragmentPageManeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        communityAdapter = CommunityAdapter(community)
        binding.rcCommunity.adapter = communityAdapter

        mediaAdapter = MediaAdapter(media)
        binding.rcMedia.adapter = mediaAdapter

        newsEducationAdapter = NewsEducationAdapter(news)
        binding.rcNews.adapter = newsEducationAdapter

        newsEducationAdapter = NewsEducationAdapter(education)
        binding.rcEducation.adapter = newsEducationAdapter

        val spinnerAdapter = ArrayAdapter(
            requireContext(),
            R.layout.custom_spinner_item,// Указываем кастомный макет
            periods
        )

        // Применяем адаптер к Spinner
        binding.tvPeriod.adapter = spinnerAdapter

        // Обработка выбора элемента
        binding.tvPeriod.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Когда ничего не выбрано
            }
        }
    }
}