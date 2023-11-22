package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.OnboardingViewModel
import dev.yaaum.presentation.core.platform.mvi.Event

sealed class OnboardingEvent : Event {
    data class GetPagesOnboardingEvent(
        val pages: List<OnboardingViewModel.OnboardingPage>,
    ) : OnboardingEvent()
}
