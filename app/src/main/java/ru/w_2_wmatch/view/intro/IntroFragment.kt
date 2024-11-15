package ru.w_2_wmatch.view.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentIntroBinding
import ru.w_2_wmatch.view.base.BaseFragment

class IntroFragment : BaseFragment() {
    private var _binding: FragmentIntroBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: IntroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnter.isSelected = true
        binding.btnReg.isSelected = false

        binding.btnEnter.setOnClickListener{
            findNavController().navigate(R.id.action_introFragment_to_authFragment)
        }

        binding.btnReg.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_regFragment)
        }
    }
}