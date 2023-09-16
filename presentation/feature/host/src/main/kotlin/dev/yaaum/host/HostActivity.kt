package dev.yaaum.host

import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cafe.adriel.voyager.navigator.Navigator
import dev.yaaum.onboarding.navigation.route.OnboardingRoute
import dev.yaaum.presentation.core.common.activity.BaseActivity
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

class HostActivity : BaseActivity() {

    override fun configureSplash() {
        installSplashScreen()
    }

    @Composable
    override fun ConfigureUi() {
        YaaumTheme {
            Navigator(OnboardingRoute())
        }
    }
}
