package ru.w_2_wmatch.view.reg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.FragmentRegBinding
import ru.w_2_wmatch.domain.models.User
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
        listener?.onTitleTextChange(R.string.reg)

        _binding = FragmentRegBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, vmFactory)[RegViewModel::class.java]

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isEntry.collect {
                /***Проверяем it на true и переходим на следующий фрагмент*/
            }
        }
        binding.btnReg.setOnClickListener {
            viewModel.reg(
                User(
                    fullname = binding.etFio.text.toString(),
                    email = binding.etEmail.text.toString(),
                    phone = binding.etPhone.text.toString(),
                    password = binding.etPass.text.toString(),
                )
            )
        }
    }
}