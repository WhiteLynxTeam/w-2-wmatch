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
import ru.w_2_wmatch.domain.models.AuthUser
import ru.w_2_wmatch.domain.models.User
import ru.w_2_wmatch.utils.uiextensions.showSnackbarLong
import ru.w_2_wmatch.view.base.BaseFragment
import ru.w_2_wmatch.view.reg.RegViewModel
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
            viewModel.isEntry.collect {
                /***Проверяем it на true и переходим на следующий фрагмент*/
                if(it) {
                    findNavController().navigate(R.id.action_authFragment_to_choosingToFillQuestionnaireFragment)
                } else {
                    showSnackbarLong("Ошибка авторизации.")
                }
            }
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