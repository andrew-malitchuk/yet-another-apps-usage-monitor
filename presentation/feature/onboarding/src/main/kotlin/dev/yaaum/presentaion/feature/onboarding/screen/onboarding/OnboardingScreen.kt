package dev.yaaum.presentaion.feature.onboarding.screen.onboarding

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.content.OnboardingContent
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi.FooViewModel
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi.OnboardingFetched
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.platform.vm.use
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel

@Composable
@Suppress("UnusedParameter", "UnusedPrivateProperty")
fun OnboardingScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    //    onboardingViewModel: OnboardingViewModel,
    @Suppress("unused")
    onboardingViewModel: FooViewModel,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen)
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false
//    val onboardingPages = onboardingViewModel.onboardingPages

    val (state, effect, event) = use(viewModel = onboardingViewModel)

    onboardingViewModel.load()

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "onboardingViewModel" to onboardingViewModel,
            "mainScreen" to mainScreen,
            "isDarkMode" to isDarkMode,
        ),
    )
    @Suppress("OptionalWhenBraces")
    YaaumTheme(isDarkMode) {
        when (state) {
            is OnboardingFetched<*> -> {
                OnboardingContent(
                    state = state,
                    onDoneClick = {
//                onboardingViewModel.setOnboardingFinished()
                        navigator.replace(mainScreen)
                    },
                    onInfoClick = {
                    },
                )
            }
        }
    }
}
