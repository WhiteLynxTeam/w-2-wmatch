package ru.w_2_wmatch.view.questionnaire.gotoprofile.part2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentGotoProfilePart2Binding
import ru.w_2_wmatch.view.base.BaseFragment

class GotoProfilePart2Fragment : BaseFragment() {

    private var _binding: FragmentGotoProfilePart2Binding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: GotoProfilePart2ViewModel

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

        _binding = FragmentGotoProfilePart2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFillQuestionnaire.setOnClickListener {
        }
    }

}