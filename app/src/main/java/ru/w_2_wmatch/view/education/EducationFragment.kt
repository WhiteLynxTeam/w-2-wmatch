package ru.w_2_wmatch.view.education

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentEducationBinding
import ru.w_2_wmatch.databinding.FragmentManePageBinding
import ru.w_2_wmatch.domain.models.Community
import ru.w_2_wmatch.domain.models.Education
import ru.w_2_wmatch.domain.models.NewsEducation
import ru.w_2_wmatch.view.education.adapters.EducationAdapter
import ru.w_2_wmatch.view.main.mane_page.adapters.CommunityAdapter
import ru.w_2_wmatch.view.main.mane_page.adapters.NewsEducationAdapter

class EducationFragment : Fragment() {
    private var _binding: FragmentEducationBinding? = null
    private val binding get() = _binding!!

    private lateinit var educationAdapter: EducationAdapter
    private lateinit var newsEducationAdapter: NewsEducationAdapter
    private lateinit var communityAdapter: CommunityAdapter


    private val toCollab = listOf(
        Education(img = R.drawable.img_education_w2w, title = "Инструкция по приложению" , description = "Познакомьтесь с будущими партнерами"),
        Education(img = R.drawable.img_education_w2w, title = "Инструкция по приложению" , description = "Познакомьтесь с будущими партнерами"),
        Education(img = R.drawable.img_education_w2w, title = "Инструкция по приложению" , description = "Познакомьтесь с будущими партнерами"),
    )
    private val match = listOf(
        NewsEducation(img = R.drawable.img_education1, title = "Найди свой Метч" , description = "Познакомьтесь с будущими партнерами"),
        NewsEducation(img = R.drawable.img_education1, title = "Найди свой Метч" , description = "Познакомьтесь c будущими партнерами"),
        NewsEducation(img = R.drawable.img_education1, title = "Найди свой Метч" , description = "Познакомьтесь c будущими партнерами"),
    )
    private val developCollabs = listOf(
        Education(img = R.drawable.img_education_w2w, title = "Инструкция по приложению" , description = "Познакомьтесь с будущими партнерами"),
        Education(img = R.drawable.img_education_w2w, title = "Инструкция по приложению" , description = "Познакомьтесь c будущими партнерами"),
        Education(img = R.drawable.img_education_w2w, title = "Инструкция по приложению" , description = "Познакомьтесь c будущими партнерами"),
    )
    private val education = listOf(
        Community(img = R.drawable.img_communiti, title = "Как создать первую коллабу?" , description = "Мы хотим подарить женщинам ВРЕМЯ, которое они ежедневно тратят на выбор подходящей одежды"),
        Community(img = R.drawable.img_communiti, title = "Как создать первую коллабу?" , description = "Мы хотим подарить женщинам ВРЕМЯ, которое они ежедневно тратят на выбор подходящей одежды"),
        Community(img = R.drawable.img_communiti, title = "Как создать первую коллабу?" , description = "Мы хотим подарить женщинам ВРЕМЯ, которое они ежедневно тратят на выбор подходящей одежды"),
    )

    companion object {
        fun newInstance() = EducationFragment()
    }

    private val viewModel: EducationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEducationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        educationAdapter = EducationAdapter(toCollab)
        binding.rcPathToCollab.adapter = educationAdapter

        newsEducationAdapter = NewsEducationAdapter(match)
        binding.rcFormedMatch.adapter = newsEducationAdapter

        educationAdapter = EducationAdapter(developCollabs)
        binding.rcDevelopCollabs.adapter = educationAdapter

        communityAdapter = CommunityAdapter(education)
        binding.rcEducation.adapter = communityAdapter
    }
}