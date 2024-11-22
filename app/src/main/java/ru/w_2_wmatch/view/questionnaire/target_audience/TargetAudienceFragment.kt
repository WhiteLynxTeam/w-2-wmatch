package ru.w_2_wmatch.view.questionnaire.target_audience

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import me.tankery.lib.circularseekbar.CircularSeekBar
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentTargetAudienceBinding
import ru.w_2_wmatch.view.base.BaseFragment

class TargetAudienceFragment : BaseFragment() {

    private var _binding: FragmentTargetAudienceBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: TargetAudienceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listener?.onTitleTextChange(R.string.questionnaire)

        _binding = FragmentTargetAudienceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressAgeWoman.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Показываем текстовое значение во время прокрутки
                binding.progressAgeWomanValue.text = progress.toString()
                binding.progressAgeWomanValue.visibility = View.VISIBLE

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // действия при начале прокрутки (если нужно)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Скрываем текстовое значение после завершения прокрутки
                binding.progressAgeWomanValue.visibility = View.GONE
            }
        })


        binding.progressGenderMan.setOnSeekBarChangeListener(object :
            CircularSeekBar.OnCircularSeekBarChangeListener {

            override fun onProgressChanged(
                circularSeekBar: CircularSeekBar?,
                progress: Float,
                fromUser: Boolean
            ) {
                val value = progress.toInt().toString()
                binding.percentGenderMan.text = "$value %"
            }

            override fun onStartTrackingTouch(seekBar: CircularSeekBar?) {
                // Можно добавить дополнительную логику, если нужно
            }

            override fun onStopTrackingTouch(seekBar: CircularSeekBar?) {
                // Можно добавить дополнительную логику, если нужно
            }
        })

    }
}