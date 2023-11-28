package dev.yaaum.presentaion.feature.onboarding.navigation.route

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.OnboardingScreen
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi.OnboardingMvi
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * Route for OnboardingScreen
 */
class OnboardingRoute : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val onboardingMvi: OnboardingMvi = koinViewModel()
        val hostViewModel: HostViewModel = koinViewModel(
            viewModelStoreOwner = LocalContext.current as ComponentActivity,
        )
        OnboardingScreen(
            navigator = navigator,
            hostViewModel = hostViewModel,
            onboardingMvi = onboardingMvi,
        )
    }
}
