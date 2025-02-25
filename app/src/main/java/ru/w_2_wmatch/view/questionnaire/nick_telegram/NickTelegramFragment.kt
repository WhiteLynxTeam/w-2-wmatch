package ru.w_2_wmatch.view.questionnaire.nick_telegram

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentNickTelegramBinding
import ru.w_2_wmatch.domain.AppState
import ru.w_2_wmatch.domain.models.Brand
import ru.w_2_wmatch.utils.uiextensions.showSnackbarLong
import ru.w_2_wmatch.view.base.BaseFragment
import javax.inject.Inject

class NickTelegramFragment : BaseFragment() {
    private var _binding: FragmentNickTelegramBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: NickTelegramViewModel

    @Inject
    lateinit var vmFactory: NickTelegramViewModel.Factory

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
        _binding = FragmentNickTelegramBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, vmFactory)[NickTelegramViewModel::class.java]

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
                            findNavController().navigate(R.id.action_nickTelegramFragment_to_brandPositionFragment)
                        } else {
                            showSnackbarLong("Ошибка сохранения.")
                        }
                    }

                    AppState.None -> {
                    }
                }
            }
        }


        binding.ivHelpNick.setOnClickListener {
            showPopupWindow(it, "Скопируйте свой ник в профиле Telegram, например: @mashaivanova")
        }

        binding.ivHelpLink.setOnClickListener {
            showPopupWindow(
                it,
                "Если вы ведёте открытый блог в  соцсетях, пожалуйста, оставьте ссылки  на все площадки."
            )
        }

        binding.ivAdd.setOnClickListener {
            animImageAdd(it)
        }

        binding.btnNext.setOnClickListener {
            viewModel.saveAnswer(
                Brand(
                    tg_nickname = binding.etNick.text.toString(),
                    blogs_list = listOf(
                        binding.etLink.text.toString(),
                    ),
                    city_name = binding.etGeo.text.toString()
                )
            )
//            findNavController().navigate(R.id.action_nickTelegramFragment_to_brandPositionFragment)
        }
    }

    private fun animImageAdd(view: View) {
        val animator = ObjectAnimator.ofFloat(view, "rotation", 0f, 90f)
        animator.duration = 500
        animator.start()
    }

    @SuppressLint("InflateParams", "MissingInflatedId")
    private fun showPopupWindow(anchorView: View, text: String) {
        // Создаем инфлятор для наших popup-элементов
        val inflater = layoutInflater
        val popupView = inflater.inflate(R.layout.help_info_key_values, null)

        val string: TextView = popupView.findViewById(R.id.text)
        string.text = text

        // Создаем PopupWindow
        val popupWindow = PopupWindow(
            popupView,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        //закрываем окно через 3 секунды
        lifecycleScope.launch {
            delay(3000)
            popupWindow.dismiss()
        }

        // Устанавливаем PopupWindow рядом с элементом
        popupWindow.showAsDropDown(anchorView) // Отображение под элементом
    }

}