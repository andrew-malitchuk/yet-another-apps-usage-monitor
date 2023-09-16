package dev.yaaum.host

import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cafe.adriel.voyager.navigator.Navigator
import dev.yaaum.onboarding.navigation.route.OnboardingRoute
import dev.yaaum.presentation.core.common.activity.BaseActivity
import dev.yaaum.presentation.core.ui.splash.exitAnimation
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HostActivity : BaseActivity() {

    private var shouldKeep = true

    override fun configureSplash() {
        installSplashScreen().apply {
            setOnExitAnimationListener {
                this@HostActivity.run {
                    it.exitAnimation()
                }
            }
            setKeepOnScreenCondition { shouldKeep }
        }
    }

    @Composable
    override fun ConfigureUi() {
        YaaumTheme {
            Navigator(OnboardingRoute())
        }
    }

    override fun observeLoading() {
        // TODO: fix it; just a demo
        GlobalScope.launch(Dispatchers.Main) {
            @Suppress("MagicNumber")
            delay(2_500L)
            shouldKeep = false
        }
    }
}
