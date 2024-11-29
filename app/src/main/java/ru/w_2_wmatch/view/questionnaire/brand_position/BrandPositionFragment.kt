package ru.w_2_wmatch.view.questionnaire.brand_position

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentBrandPositionBinding
import ru.w_2_wmatch.domain.AppState
import ru.w_2_wmatch.domain.models.Brand
import ru.w_2_wmatch.utils.uiextensions.showSnackbarLong
import ru.w_2_wmatch.view.base.BaseFragment
import javax.inject.Inject

class BrandPositionFragment : BaseFragment() {
    private var _binding: FragmentBrandPositionBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: BrandPositionViewModel

    @Inject
    lateinit var vmFactory: BrandPositionViewModel.Factory

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

        _binding = FragmentBrandPositionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, vmFactory)[BrandPositionViewModel::class.java]

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.appStateFlow.collect {
                when (it) {
                    is AppState.Error -> {
                    }

                    AppState.Loading -> {
                    }

                    is AppState.Success<*> -> {
                        if (it.data as Boolean) {
                            showSnackbarLong("Данные сохранены.")
                            findNavController().navigate(R.id.action_brandPositionFragment_to_socialNetworkLinkFragment)
                        } else {
                            showSnackbarLong("Ошибка сохранения.")
                        }
                    }

                    AppState.None -> {
                    }
                }
            }
        }

        binding.btnNext.setOnClickListener {
            viewModel.saveAnswer(
                Brand(
                    name_brand = binding.etBrandName.text.toString(),
                    position_in_brand = binding.etPosition.text.toString()
                )
            )

//            findNavController().navigate(R.id.action_brandPositionFragment_to_socialNetworkLinkFragment)
        }
    }

}