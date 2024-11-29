package ru.w_2_wmatch.view.questionnaire.personal_photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentPersonalPhotoBinding
import ru.w_2_wmatch.view.base.BaseFragment

class PersonalPhotoFragment : BaseFragment() {

    private var _binding: FragmentPersonalPhotoBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PersonalPhotoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listener?.apply {
            onTitleTextChange(R.string.your_personal_photo)
            showBackArrow()
            showBackTitle()
            hideAvatar()
            hideNotification()
        }

        _binding = FragmentPersonalPhotoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}