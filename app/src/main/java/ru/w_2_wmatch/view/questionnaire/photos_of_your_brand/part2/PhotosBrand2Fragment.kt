package ru.w_2_wmatch.view.questionnaire.photos_of_your_brand.part2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentPhotosBrand2Binding
import ru.w_2_wmatch.databinding.FragmentPhotosBrandBinding
import ru.w_2_wmatch.view.base.BaseFragment
import ru.w_2_wmatch.view.questionnaire.photos_of_your_brand.part1.PhotosBrandViewModel

class PhotosBrand2Fragment : BaseFragment() {

    private var _binding: FragmentPhotosBrand2Binding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PhotosBrand2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listener?.apply {
            onTitleTextChange(R.string.photos_of_your_brand)
            showBackArrow()
            showBackTitle()
            hideAvatar()
            hideNotification()
        }

        _binding = FragmentPhotosBrand2Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}