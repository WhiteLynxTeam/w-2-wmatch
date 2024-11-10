package ru.w_2_wmatch.view.questionnaire.target_audience

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import ru.w_2_wmatch.databinding.FragmentTargetAudienceBinding
import ru.w_2_wmatch.view.questionnaire.QuestionnaireViewModel

class TargetAudienceFragment : Fragment() {

    private var _binding: FragmentTargetAudienceBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: QuestionnaireViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTargetAudienceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}