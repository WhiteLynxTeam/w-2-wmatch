package ru.w_2_wmatch.view.questionnaire.gotoprofile

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.w_2_wmatch.R

class GotoProfileFragment : Fragment() {

    companion object {
        fun newInstance() = GotoProfileFragment()
    }

    private val viewModel: GotoProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_goto_profile, container, false)
    }
}