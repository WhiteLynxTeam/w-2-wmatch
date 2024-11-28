package ru.w_2_wmatch.view.questionnaire.offline_space

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentOfflineSpaceBinding
import ru.w_2_wmatch.view.base.BaseFragment

class OfflineSpaceFragment : BaseFragment() {

    private var _binding: FragmentOfflineSpaceBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: OfflineSpaceViewModel

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

        _binding = FragmentOfflineSpaceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivAdd.setOnClickListener {
            animImageAdd(it)
        }

    }

    //Анимация кнопки плюс
    private fun animImageAdd(view: View) {
        val animator = ObjectAnimator.ofFloat(view, "rotation", 0f, 90f)
        animator.duration = 500
        animator.start()
    }
}