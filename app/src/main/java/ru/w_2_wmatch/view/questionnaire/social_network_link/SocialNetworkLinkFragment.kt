package ru.w_2_wmatch.view.questionnaire.social_network_link

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentSocialNetworkLinkBinding
import ru.w_2_wmatch.view.auth.AuthViewModel

class SocialNetworkLinkFragment : Fragment() {

    private var _binding: FragmentSocialNetworkLinkBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentSocialNetworkLinkBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}