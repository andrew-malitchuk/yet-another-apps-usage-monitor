package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.event.MviEvent

@Immutable
sealed class OnboardingMviEvent : MviEvent {
    data class GetPagesMviEvent(val data: List<OnboardingMvi.OnboardingPage>) :
        OnboardingMviEvent()
    data object OnDoneMviEvent : OnboardingMviEvent()
}
