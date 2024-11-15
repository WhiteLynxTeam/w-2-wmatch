package ru.w_2_wmatch.view.questionnaire.target_audience

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentTargetAudienceBinding
import ru.w_2_wmatch.view.base.BaseFragment

class TargetAudienceFragment : BaseFragment() {

    private var _binding: FragmentTargetAudienceBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: TargetAudienceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listener?.onTitleTextChange(R.string.questionnaire)

        _binding = FragmentTargetAudienceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}