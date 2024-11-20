package ru.w_2_wmatch.view.activity

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.NavHostFragment
import kotlinx.coroutines.launch
import ru.w_2_wmatch.R
import ru.w_2_wmatch.databinding.ActivityMainBinding
import ru.w_2_wmatch.utils.uiextensions.hide
import ru.w_2_wmatch.utils.uiextensions.show

class MainActivity : AppCompatActivity(), OnHeaderChangeListener {
    private lateinit var binding: ActivityMainBinding

    private val navController by lazy {
        NavHostFragment.findNavController(supportFragmentManager.findFragmentById(R.id.fragment_placeholder) as NavHostFragment)
    }

    private val fragmentsWithoutHeader = listOf(
        R.id.introFragment,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initShowOrHideHeader()

        binding.btnBack.setOnClickListener {
            onBackClick()
        }
    }

    private fun initShowOrHideHeader() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                navController.addOnDestinationChangedListener { _, destination, _ ->
                    with(binding) {
                        if (fragmentsWithoutHeader.contains(destination.id)) {
                            btnBack.hide()
                            backTitle.hide()
                        } else {
                            btnBack.show()
                            backTitle.show()
                        }

                    }
                }
            }
        }
    }

    override fun onTitleTextChange(newText: String) {
        binding.backTitle.text = newText

    }

    override fun onTitleTextChange(idRes: Int) {
        try {
            binding.backTitle.setText(idRes)
        } catch (e: Resources.NotFoundException) {
            binding.backTitle.text = ""
        }
    }

    override fun onBackClick() {
        navController.popBackStack()
    }
}