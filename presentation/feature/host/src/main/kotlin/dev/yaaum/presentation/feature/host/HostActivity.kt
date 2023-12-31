package dev.yaaum.presentation.feature.host

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.platform.activity.BaseActivity
import dev.yaaum.presentation.core.ui.splash.exitAnimation
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel
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
        val theme by hostViewModel.currentThemeUiModel.collectAsState()
        val isOnboardingFinished = hostViewModel.isOnboardingFinished.collectAsStateWithLifecycle()
        val isSetupLoading = hostViewModel.isSetupLoadingStateFlow.collectAsStateWithLifecycle(null)

        if (isSetupLoading.value == false) {
            shouldKeepSplash = false
            YaaumTheme(theme = theme) {
//                val destinationAfterSplash = if (isOnboardingFinished.value == true) {
                val destinationAfterSplash = if (false) {
                    rememberScreen(RouteGraph.MainScreen)
                } else {
                    rememberScreen(RouteGraph.OnboardingScreen)
                }
                Navigator(destinationAfterSplash)
            }
        }
    }
}
