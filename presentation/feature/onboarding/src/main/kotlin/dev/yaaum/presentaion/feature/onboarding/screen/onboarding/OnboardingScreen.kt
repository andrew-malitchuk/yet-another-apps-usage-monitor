package dev.yaaum.presentaion.feature.onboarding.screen.onboarding

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.content.OnboardingContent
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel

@Composable
@Suppress("UnusedParameter", "UnusedPrivateProperty")
fun OnboardingScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    @Suppress("unused")
    onboardingViewModel: OnboardingViewModel,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen)
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false
    val onboardingPages = onboardingViewModel.onboardingPages

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "onboardingViewModel" to onboardingViewModel,
            "mainScreen" to mainScreen,
            "isDarkMode" to isDarkMode,
        ),
    )
    YaaumTheme(isDarkMode) {
        OnboardingContent(
            onboardingPages = onboardingPages,
            onDoneClick = {
                onboardingViewModel.setOnboardingFinished()
                navigator.replace(mainScreen)
            },
            onInfoClick = {
            },
        )
    }
}
