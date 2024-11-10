package ru.w_2_wmatch.view.questionnaire.nick_telegram

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentNickTelegramBinding

class NickTelegramFragment : Fragment() {

    private var _binding: FragmentNickTelegramBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: NickTelegramViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNickTelegramBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivHelpNick.setOnClickListener {
            showPopupWindow(it)
        }

        binding.ivHelpLink.setOnClickListener {
            showPopupWindow(it)
        }

        binding.ivAdd.setOnClickListener {
            animImageAdd(it)
        }
    }

    private fun animImageAdd(view: View) {
        val animator = ObjectAnimator.ofFloat(view, "rotation", 0f, 90f)
        animator.duration = 500
        animator.start()
    }

    @SuppressLint("InflateParams", "MissingInflatedId")
    private fun showPopupWindow(anchorView: View) {
        // Создаем инфлятор для наших popup-элементов
        val inflater = layoutInflater
        val popupView = inflater.inflate(R.layout.help_info_builder, null)

        // Создаем PopupWindow
        val popupWindow = PopupWindow(popupView,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT)

        // Устанавливаем кнопку закрытия
        val closeButton: Button = popupView.findViewById(R.id.btn_send)
        closeButton.setOnClickListener {
            popupWindow.dismiss() // Закрываем всплывающее окно
        }

        // Устанавливаем PopupWindow рядом с элементом
        popupWindow.showAsDropDown(anchorView) // Отображение под элементом
    }

    companion object {
        fun newInstance() = NickTelegramFragment()
    }
}