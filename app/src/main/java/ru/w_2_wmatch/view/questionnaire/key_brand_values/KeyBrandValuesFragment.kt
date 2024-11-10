package ru.w_2_wmatch.view.questionnaire.key_brand_values

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
import ru.w_2_wmatch.databinding.FragmentKeyBrandValuesBinding

class KeyBrandValuesFragment : Fragment() {

    private var _binding: FragmentKeyBrandValuesBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: KeyBrandValuesViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKeyBrandValuesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivHelpKeyValues.setOnClickListener {
            showPopupWindow(it)
        }

        binding.ivHelpUniqBrand.setOnClickListener {
            showPopupWindow(it)
        }

        binding.value15.setOnClickListener {
            binding.value15.setBackgroundResource(R.drawable.bg_outline_brand_selected)
        }
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
        fun newInstance() = KeyBrandValuesFragment()
    }

}