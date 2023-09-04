package dev.yaaum.onboarding.navigation.route

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.yaaum.onboarding.screen.composable.onboarding.OnboardingScreen

class OnboardingRoute : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
//        val mainScreen = rememberScreen(SharedScreen.MainScreen)

        OnboardingScreen(navigator)
    }
}
