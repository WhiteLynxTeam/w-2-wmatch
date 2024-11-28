package ru.w_2_wmatch.view.questionnaire.gotoprofile.part1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentGotoProfilePart1Binding
import ru.w_2_wmatch.view.base.BaseFragment

class GotoProfilePart1Fragment : BaseFragment() {
    private var _binding: FragmentGotoProfilePart1Binding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: GotoProfilePart1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listener?.apply {
            onTitleTextChange(R.string.questionnaire)
            hideBackArrow()
            showBackTitle()
            hideAvatar()
        }
        _binding = FragmentGotoProfilePart1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFillQuestionnaire.setOnClickListener {
            findNavController().navigate(R.id.action_gotoProfilePart1Fragment_to_manePageFragment)
        }
    }
}