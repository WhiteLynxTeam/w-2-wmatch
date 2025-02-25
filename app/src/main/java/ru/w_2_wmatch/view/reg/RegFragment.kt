package ru.w_2_wmatch.view.reg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.redmadrobot.inputmask.MaskedTextChangedListener
import kotlinx.coroutines.launch
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentRegBinding
import ru.w_2_wmatch.domain.AppState
import ru.w_2_wmatch.domain.models.User
import ru.w_2_wmatch.utils.isEmailValid
import ru.w_2_wmatch.utils.uiextensions.hide
import ru.w_2_wmatch.utils.uiextensions.show
import ru.w_2_wmatch.utils.uiextensions.showSnackbarLong
import ru.w_2_wmatch.view.base.BaseFragment
import javax.inject.Inject

class RegFragment : BaseFragment() {
    private var _binding: FragmentRegBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: RegViewModel

    @Inject
    lateinit var vmFactory: RegViewModel.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listener?.apply {
            onTitleTextChange(R.string.reg)
            hideBackArrow()
            showBackTitle()
            hideAvatar()
            hideNotification()
        }

        _binding = FragmentRegBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, vmFactory)[RegViewModel::class.java]

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.appStateFlow.collect {
                when (it) {
                    is AppState.Error -> {
                        binding.progressBar.hide()
                    }

                    AppState.Loading -> {
                        binding.progressBar.show()
                    }

                    is AppState.Success<*> -> {
                        binding.progressBar.hide()
                        if(it.data as Boolean) {
                            showSnackbarLong("Пользователь зарегистрирован.")
                            findNavController().navigate(R.id.action_regFragment_to_choosingToFillQuestionnaireFragment)
                        } else {
                            showSnackbarLong("Ошибка регистрации.")
                        }
                    }

                    AppState.None -> {
                        binding.progressBar.hide()
                    }
                }
            }
        }

        binding.tvEnter.setOnClickListener {
            findNavController().navigate(R.id.action_regFragment_to_authFragment)
        }

        binding.btnReg.setOnClickListener {
            if (!binding.etEmail.text.toString().isEmailValid()) {
                showSnackbarLong("Введите корректный адрес email")
                return@setOnClickListener
            }

            val elements = listOf(
                binding.etFio,
                binding.etEmail,
                binding.etPhone,
                binding.etPass
            )

            if (checkFields(elements)){
                showSnackbarLong("Заполните все поля")
                return@setOnClickListener
            }

            viewModel.reg(
                User(
                    fullname = binding.etFio.text.toString(),
                    email = binding.etEmail.text.toString(),
                    phone = binding.etPhone.text.toString(),
                    password = binding.etPass.text.toString(),
                )
            )
        }

        val listener = MaskedTextChangedListener( "+7[0000000000]", binding.etPhone)
        binding.etPhone.addTextChangedListener(listener)
        binding.etPhone.onFocusChangeListener = listener
    }

    fun checkFields(elements: List<TextInputEditText>): Boolean {
        return elements.none { it.text?.isNotEmpty() ?: false}
    }
}