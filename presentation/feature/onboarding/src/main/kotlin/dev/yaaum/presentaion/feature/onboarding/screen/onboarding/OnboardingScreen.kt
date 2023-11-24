package dev.yaaum.presentaion.feature.onboarding.screen.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.content.OnboardingFetchedContent
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi.OnboardingMvi
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi.OnboardingMviEffect
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.platform.mvi.MviPartialState
import dev.yaaum.presentation.core.ui.composable.content.loading.DefaultLoadingContent
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel

@Composable
@Suppress("UnusedParameter", "UnusedPrivateProperty")
fun OnboardingScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    //    onboardingViewModel: OnboardingViewModel,
    @Suppress("unused")
    onboardingMvi: OnboardingMvi,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen)
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false
//    val onboardingPages = onboardingViewModel.onboardingPages

    val state by onboardingMvi.state.collectAsState()
    val effect by onboardingMvi.effect.collectAsState(null)

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "onboardingMvi" to onboardingMvi,
            "mainScreen" to mainScreen,
            "isDarkMode" to isDarkMode,
        ),
    )
    @Suppress("OptionalWhenBraces")
    YaaumTheme(isDarkMode) {
        when (state.partialState) {
            MviPartialState.FETCHED -> {
                OnboardingFetchedContent(
                    state = state,
                    onDoneClick = {
                        onboardingMvi.sendEffect(OnboardingMviEffect.GoToMainScreenMviEffect)
                    },
                    onInfoClick = {
                    },
                )
            }

            MviPartialState.LOADING -> {
                DefaultLoadingContent()
            }

            MviPartialState.ERROR -> {
            }

            MviPartialState.EMPTY -> {
            }
        }
    }

    when (effect) {
        OnboardingMviEffect.GoToMainScreenMviEffect -> navigator.replace(mainScreen)

        null -> Unit
    }
}
