package dev.yaaum.presentaion.feature.onboarding.screen.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentaion.feature.onboarding.dialog.OnboardingDialogContent
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.content.fetched.OnboardingFetchedContent
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi.OnboardingMvi
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi.OnboardingMviEffect
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi.OnboardingMviEvent
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.platform.mvi.MviPartialState
import dev.yaaum.presentation.core.ui.composable.content.empty.DefaultEmptyContent
import dev.yaaum.presentation.core.ui.composable.content.error.DefaultErrorContent
import dev.yaaum.presentation.core.ui.composable.content.loading.DefaultLoadingContent
import dev.yaaum.presentation.core.ui.composable.dialog.YaaumBottomSheetDialog
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel

@Composable
@Suppress("UnusedPrivateProperty")
fun OnboardingScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    onboardingMvi: OnboardingMvi,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen)
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false

    val state by onboardingMvi.state.collectAsState()
    val effect by onboardingMvi.effect.collectAsState(null)

    var showSheet by remember { mutableStateOf(false) }

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "onboardingMvi" to onboardingMvi,
            "mainScreen" to mainScreen,
            "isDarkMode" to isDarkMode,
            "state" to state,
            "effect" to effect,
        ),
    )

    if (showSheet) {
        YaaumBottomSheetDialog(
            onDismiss = {
                showSheet = false
            },
        ) {
            OnboardingDialogContent(
                onDismiss = {
                    showSheet = false
                },
            )
        }
    }

    YaaumTheme(isDarkMode) {
        when (state.partialState) {
            MviPartialState.FETCHED ->
                OnboardingFetchedContent(
                    state = state,
                    onDoneClick = {
                        onboardingMvi.sendEvent(OnboardingMviEvent.OnDoneMviEvent)
                    },
                    onInfoClick = {
                        showSheet = true
                    },
                )

            MviPartialState.LOADING ->
                DefaultLoadingContent()

            MviPartialState.ERROR ->
                state.error?.let {
                    DefaultErrorContent(error = it)
                }

            MviPartialState.EMPTY ->
                DefaultEmptyContent()
        }
    }

    when (effect) {
        OnboardingMviEffect.GoToMainScreenMviEffect -> navigator.replace(mainScreen)

        null -> Unit
    }
}
