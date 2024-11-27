package ru.w_2_wmatch.view.main.mane_page

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentIntroBinding
import ru.w_2_wmatch.databinding.FragmentManePageBinding
import ru.w_2_wmatch.view.base.BaseFragment
import ru.w_2_wmatch.view.reg.choosing_to_fill_questionnaire.ChoosingToFillQuestionnaireViewModel

class ManePageFragment : BaseFragment() {
    private var _binding: FragmentManePageBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ManePageViewModel

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
    }
}