package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.OnboardingViewModel
import dev.yaaum.presentation.core.platform.mvi.MviEvent

@Immutable
sealed class OnboardingMviEvent : MviEvent {
    data class GetPagesMviEvent(val data: List<OnboardingViewModel.OnboardingPage>) :
        OnboardingMviEvent()

    data object GoToNextScreenMviEvent : OnboardingMviEvent()
}
