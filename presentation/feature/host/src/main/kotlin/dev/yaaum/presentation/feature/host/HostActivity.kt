package dev.yaaum.presentation.feature.host

import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.platform.activity.BaseActivity
import dev.yaaum.presentation.core.ui.splash.exitAnimation
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.composable.HostViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HostActivity : BaseActivity() {

    private val hostViewModel: HostViewModel by viewModel()

    private var shouldKeepSplash = true

    override fun configureSplash() {
        installSplashScreen().apply {
            setOnExitAnimationListener {
                this@HostActivity.run {
                    it.exitAnimation()
                }
            }
            setKeepOnScreenCondition { shouldKeepSplash }
        }
    }

    @Composable
    override fun ConfigureUi() {
        val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false
        YaaumTheme(isDarkMode) {
            val onboardingRoute = rememberScreen(RouteGraph.OnboardingScreen)
            Navigator(onboardingRoute)
        }
    }

    override fun observeLoading() {
        lifecycleScope.launch {
            hostViewModel.isSetupLoadingStateFlow.collect { isLoading ->
                isLoading?.let {
                    shouldKeepSplash = it
                }
            }
        }
    }
}
