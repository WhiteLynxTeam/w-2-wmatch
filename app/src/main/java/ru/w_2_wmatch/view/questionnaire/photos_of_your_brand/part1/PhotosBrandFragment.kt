package ru.w_2_wmatch.view.questionnaire.photos_of_your_brand.part1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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
            showBackArrow()
            showBackTitle()
            hideAvatar()
            hideNotification()
        }

        _binding = FragmentPhotosBrandBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_photosBrandFragment_to_gotoProfilePart1Fragment)
        }
    }
}