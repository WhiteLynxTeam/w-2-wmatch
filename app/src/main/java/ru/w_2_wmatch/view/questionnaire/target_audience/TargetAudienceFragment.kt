package ru.w_2_wmatch.view.questionnaire.target_audience

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        binding.progressGenderWoman.setOnSeekBarChangeListener(object :
            CircularSeekBar.OnCircularSeekBarChangeListener {

            override fun onProgressChanged(
                circularSeekBar: CircularSeekBar?,
                progress: Float,
                fromUser: Boolean
            ) {
                val value = progress.toInt().toString()
                binding.percentGenderWoman.text = "$value %"
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