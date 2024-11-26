package ru.w_2_wmatch.view.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentIntroBinding
import ru.w_2_wmatch.utils.uiextensions.gone
import ru.w_2_wmatch.utils.uiextensions.show
import ru.w_2_wmatch.view.base.BaseFragment
import javax.inject.Inject

class IntroFragment : BaseFragment() {
    private var _binding: FragmentIntroBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: IntroViewModel

    @Inject
    lateinit var vmFactory: IntroViewModel.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listener?.onTitleTextChange("")
        listener?.hideBackArrow()
        listener?.hideBackTitle()
        listener?.hideAvatar()
        listener?.hideNotification()

        _binding = FragmentIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, vmFactory)[IntroViewModel::class.java]

        binding.btnEnter.isSelected = true
        binding.btnReg.isSelected = false

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.introStateFlow.collect {
                when (it) {
                    IntroState.Auth -> {
                        binding.progressBar.gone()
                    }

                    IntroState.Enter -> {
//                        findNavController().navigate(R.id.action_introFragment_to_choosingToFillQuestionnaireFragment)
                        binding.progressBar.gone()
                        binding.btnReg.gone()
                    }

                    IntroState.Error -> {
                        binding.progressBar.gone()
                    }

                    IntroState.Loading -> {
                        binding.progressBar.show()
                    }
                }
            }
        }

        binding.btnEnter.setOnClickListener {
            if (viewModel.introStateFlow.value == IntroState.Enter) {
                findNavController().navigate(R.id.action_introFragment_to_choosingToFillQuestionnaireFragment)
            } else {
                findNavController().navigate(R.id.action_introFragment_to_authFragment)
            }
        }

        binding.btnReg.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_regFragment)
        }

        binding.logo.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_nickTelegramFragment2)
        }
    }
}