package ru.w_2_wmatch.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentAuthBinding
import ru.w_2_wmatch.domain.AppState
import ru.w_2_wmatch.domain.models.AuthUser
import ru.w_2_wmatch.utils.uiextensions.hide
import ru.w_2_wmatch.utils.uiextensions.show
import ru.w_2_wmatch.utils.uiextensions.showSnackbarLong
import ru.w_2_wmatch.view.base.BaseFragment
import javax.inject.Inject

class AuthFragment : BaseFragment() {
    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: AuthViewModel

    @Inject
    lateinit var vmFactory: AuthViewModel.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listener?.onTitleTextChange(R.string.enter)

        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, vmFactory)[AuthViewModel::class.java]

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.appStateFlow.collect {
                when (it) {
                    is AppState.Error -> {
                        println("AuthFragment начало AppState.Error")
                        binding.progressBar.hide()
                    }

                    AppState.Loading -> {
                        println("AuthFragment начало AppState.Loading")
                        binding.progressBar.show()
                    }

                    is AppState.Success<*> -> {
                        println("AuthFragment начало AppState.Success")
                        binding.progressBar.hide()
                        if(it.data as Boolean) {
                            findNavController().navigate(R.id.action_authFragment_to_choosingToFillQuestionnaireFragment)
                        } else {
                            showSnackbarLong("Ошибка авторизации.")
                        }
                    }

                    AppState.None -> {
                        println("AuthFragment начало AppState.None")
                        binding.progressBar.hide()
                    }
                }
            }
        }

        binding.tvReg.setOnClickListener {
            findNavController().navigate(R.id.action_authFragment_to_regFragment)
        }

        binding.btnEnter.setOnClickListener {
            viewModel.auth(
                AuthUser(
                    login = binding.etEmail.text.toString(),
                    password = binding.etPass.text.toString(),
                )
            )
        }
    }
}