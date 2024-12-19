package ru.w_2_wmatch.view.activity

import android.content.pm.ActivityInfo
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
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

    private val fragmentsWithoutToolbars = listOf(
        R.id.brandPositionFragment,
        R.id.choosingToFillQuestionnaireFragment,
        R.id.keyBrandValuesFragment,
        R.id.nickTelegramFragment,
        R.id.socialNetworkLinkFragment,
        R.id.gotoProfilePart1Fragment,
        R.id.photosBrandFragment,
        R.id.introFragment,
        R.id.authFragment,
        R.id.regFragment,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setupWithNavController(navController)

        initMenu()
        initShowOrHide()

        binding.btnBack.setOnClickListener {
            onBackClick()
        }

        binding.avatar.setOnClickListener {
            navController.navigate(R.id.profileFragment)
        }
    }

    private fun initMenu() {
        with(binding) {
            fabActive.setOnClickListener {
                navController.navigate(R.id.pageManeFragment)
            }
            fabNoactive.setOnClickListener {
                navController.navigate(R.id.pageManeFragment)
            }
            bottomNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.pageEducationFragment -> {
                        navController.navigate(R.id.pageEducationFragment)
                        true
                    }

                    R.id.pageCollabsFragment -> {
                        navController.navigate(R.id.pageCollabsFragment)
                        true
                    }
                    else -> false
                }
            }
        }

    }

    private fun initShowOrHide() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                navController.addOnDestinationChangedListener { _, destination, _ ->
                    with(binding) {
                        if (fragmentsWithoutToolbars.contains(destination.id)) {
                            bottomNavigation.hide()
                            fabActive.hide()
                            fabNoactive.hide()
                        } else {
                            bottomNavigation.show()
                            fabNoactive.show()
//                            fabNoactive.show()
                        }
                    }
                }
            }
        }
    }

    override fun hideBackArrow() {
        binding.btnBack.hide()
    }

    override fun showBackArrow() {
        binding.btnBack.show()
    }

    override fun hideBackTitle() {
        binding.backTitle.hide()
    }

    override fun showBackTitle() {
        binding.backTitle.show()
    }

    override fun hideAvatar() {
        binding.avatar.hide()
    }

    override fun showAvatar() {
        binding.avatar.show()
    }

    override fun hideNotification() {
        binding.notification.hide()
    }

    override fun showNotification() {
        binding.notification.show()
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