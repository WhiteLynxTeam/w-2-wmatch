package ru.w_2_wmatch.view.questionnaire

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import ru.w_2_wmatch.databinding.FragmentQuestionnaireBinding
import ru.w_2_wmatch.view.base.BaseViewPagerAdapter
import ru.w_2_wmatch.view.questionnaire.nick_telegram.NickTelegramFragment

class QuestionnaireFragment : Fragment() {

    private var _binding: FragmentQuestionnaireBinding? = null
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
        _binding = FragmentQuestionnaireBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addViewPager()

    }

    private fun addViewPager(){
        binding.vpCatalog.adapter = BaseViewPagerAdapter(
            this, arrayOf(
                NickTelegramFragment.newInstance()
            )
        )
    }
}