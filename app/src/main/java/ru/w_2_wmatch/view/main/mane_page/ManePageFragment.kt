package ru.w_2_wmatch.view.main.mane_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentManePageBinding
import ru.w_2_wmatch.domain.models.Community
import ru.w_2_wmatch.domain.models.Media
import ru.w_2_wmatch.domain.models.NewsEducation
import ru.w_2_wmatch.view.base.BaseFragment
import ru.w_2_wmatch.view.main.mane_page.adapters.CommunityAdapter
import ru.w_2_wmatch.view.main.mane_page.adapters.MediaAdapter
import ru.w_2_wmatch.view.main.mane_page.adapters.NewsEducationAdapter

class ManePageFragment : BaseFragment() {
    private var _binding: FragmentManePageBinding? = null
    private val binding get() = _binding!!

    private lateinit var communityAdapter: CommunityAdapter
    private lateinit var mediaAdapter: MediaAdapter
    private lateinit var newsEducationAdapter: NewsEducationAdapter

    private lateinit var viewModel: ManePageViewModel

    private val community = listOf(
        Community(img = R.drawable.img_communiti, title = "Как создать первую коллабу?" , description = "Мы хотим подарить женщинам ВРЕМЯ, которое они ежедневно тратят на выбор подходящей одежды" ),
        Community(img = R.drawable.img_communiti, title = "Как создать первую коллабу?" , description = "Мы хотим подарить женщинам ВРЕМЯ, которое они ежедневно тратят на выбор подходящей одежды" ),
        Community(img = R.drawable.img_communiti, title = "Как создать первую коллабу?" , description = "Мы хотим подарить женщинам ВРЕМЯ, которое они ежедневно тратят на выбор подходящей одежды" ),
        Community(img = R.drawable.img_communiti, title = "Как создать первую коллабу?" , description = "Мы хотим подарить женщинам ВРЕМЯ, которое они ежедневно тратят на выбор подходящей одежды" ),
    )

    private val media = listOf(
        Media(img = R.drawable.img_media1, title = "The Wellnus & Sarro" , description = "Познакомьтесь c будущими партнерам"),
        Media(img = R.drawable.img_media2, title = "The Wellnus & Sarro" , description = "Познакомьтесь c будущими партнерам"),
        Media(img = R.drawable.img_media1, title = "The Wellnus & Sarro" , description = "Познакомьтесь c будущими партнерам"),
        Media(img = R.drawable.img_media2, title = "The Wellnus & Sarro" , description = "Познакомьтесь c будущими партнерам"),
    )
    private val news = listOf(
        NewsEducation(img = R.drawable.img_news1, title = "The Wellnus & Sarro" , description = "Познакомьтесь c будущими партнерам"),
        NewsEducation(img = R.drawable.img_news1, title = "The Wellnus & Sarro" , description = "Познакомьтесь c будущими партнерам"),
        NewsEducation(img = R.drawable.img_news1, title = "The Wellnus & Sarro" , description = "Познакомьтесь c будущими партнерам"),
    )
    private val education = listOf(
        NewsEducation(img = R.drawable.img_education1, title = "The Wellnus & Sarro" , description = "Познакомьтесь c будущими партнерам"),
        NewsEducation(img = R.drawable.img_education1, title = "The Wellnus & Sarro" , description = "Познакомьтесь c будущими партнерам"),
        NewsEducation(img = R.drawable.img_education1, title = "The Wellnus & Sarro" , description = "Познакомьтесь c будущими партнерам"),
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

        _binding = FragmentManePageBinding.inflate(inflater, container, false)
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

    }
}