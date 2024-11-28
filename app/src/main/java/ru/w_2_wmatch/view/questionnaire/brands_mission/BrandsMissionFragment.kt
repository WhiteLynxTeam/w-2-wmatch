package ru.w_2_wmatch.view.questionnaire.brands_mission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentBrandsMissionBinding
import ru.w_2_wmatch.view.base.BaseFragment

class BrandsMissionFragment : BaseFragment() {

    private var _binding: FragmentBrandsMissionBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: BrandsMissionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listener?.apply {
            onTitleTextChange(R.string.questionnaire)
            hideBackArrow()
            showBackTitle()
            hideAvatar()
            hideNotification()
        }

        _binding = FragmentBrandsMissionBinding.inflate(inflater, container, false)
        return binding.root
    }

}