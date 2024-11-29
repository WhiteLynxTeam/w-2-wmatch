package ru.w_2_wmatch.view.questionnaire.key_brand_values

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentKeyBrandValuesBinding
import ru.w_2_wmatch.view.base.BaseFragment

class KeyBrandValuesFragment : BaseFragment() {

    private var _binding: FragmentKeyBrandValuesBinding? = null
    private val binding get() = _binding!!

    private val onTimeClickListener = View.OnClickListener { view ->
        view.setBackgroundResource(R.drawable.bg_outline_brand_selected)
    }

    private lateinit var viewModel: KeyBrandValuesViewModel

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

        _binding = FragmentKeyBrandValuesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_keyBrandValuesFragment_to_photosBrandFragment)
        }

        binding.ivHelpKeyValues.setOnClickListener {
            showPopupWindow(
                it,
                "В зависимости от выбранных ценностей алгоритм подберет релевантные бренды."
            )
        }

        binding.ivHelpUniqBrand.setOnClickListener {
            showPopupWindow(it, "Например: «Яркая детская одежда с принтами ручной работы»")
        }

        with(binding) {
            value1.setOnClickListener(onTimeClickListener)
            value2.setOnClickListener(onTimeClickListener)
            value3.setOnClickListener(onTimeClickListener)
            value4.setOnClickListener(onTimeClickListener)
            value5.setOnClickListener(onTimeClickListener)
            value6.setOnClickListener(onTimeClickListener)
            value7.setOnClickListener(onTimeClickListener)
            value8.setOnClickListener(onTimeClickListener)
            value9.setOnClickListener(onTimeClickListener)
            value10.setOnClickListener(onTimeClickListener)
            value11.setOnClickListener(onTimeClickListener)
            value12.setOnClickListener(onTimeClickListener)
            value13.setOnClickListener(onTimeClickListener)
            value14.setOnClickListener(onTimeClickListener)
            value15.setOnClickListener(onTimeClickListener)
            value16.setOnClickListener(onTimeClickListener)
            value17.setOnClickListener(onTimeClickListener)
            value18.setOnClickListener(onTimeClickListener)
            value19.setOnClickListener(onTimeClickListener)
            value20.setOnClickListener(onTimeClickListener)
            value21.setOnClickListener(onTimeClickListener)
            value22.setOnClickListener(onTimeClickListener)
            value23.setOnClickListener(onTimeClickListener)
            value24.setOnClickListener(onTimeClickListener)
            value25.setOnClickListener(onTimeClickListener)
            value26.setOnClickListener(onTimeClickListener)
            value27.setOnClickListener(onTimeClickListener)
            value28.setOnClickListener(onTimeClickListener)
            value29.setOnClickListener(onTimeClickListener)
            value30.setOnClickListener(onTimeClickListener)
            value31.setOnClickListener(onTimeClickListener)
            value32.setOnClickListener(onTimeClickListener)
            value33.setOnClickListener(onTimeClickListener)
            value34.setOnClickListener(onTimeClickListener)
            value35.setOnClickListener(onTimeClickListener)
            value36.setOnClickListener(onTimeClickListener)
            value37.setOnClickListener(onTimeClickListener)
        }
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