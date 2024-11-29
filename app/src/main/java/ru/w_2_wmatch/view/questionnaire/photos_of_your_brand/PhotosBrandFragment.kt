package ru.w_2_wmatch.view.questionnaire.photos_of_your_brand

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentPhotosBrandBinding
import ru.w_2_wmatch.view.base.BaseFragment

class PhotosBrandFragment : BaseFragment() {

    private var _binding: FragmentPhotosBrandBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PhotosBrandViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listener?.apply {
            onTitleTextChange(R.string.photos_of_your_brand)
            hideBackArrow()
            showBackTitle()
            hideAvatar()
            hideNotification()
        }

        _binding = FragmentPhotosBrandBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}