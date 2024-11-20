package ru.w_2_wmatch.view.reg.choosing_to_fill_questionnaire

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentChoosingToFillQuestionnaireBinding
import ru.w_2_wmatch.view.base.BaseFragment

class ChoosingToFillQuestionnaireFragment : BaseFragment() {

    private var _binding: FragmentChoosingToFillQuestionnaireBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ChoosingToFillQuestionnaireViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listener?.onTitleTextChange(R.string.reg)

        _binding = FragmentChoosingToFillQuestionnaireBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}