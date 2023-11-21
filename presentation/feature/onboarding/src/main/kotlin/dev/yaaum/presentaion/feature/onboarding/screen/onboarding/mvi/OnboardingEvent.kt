package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import dev.yaaum.presentation.core.platform.mvi.Event

sealed class OnboardingEvent : Event() {
    data object GetOnboardingPagesEvent : OnboardingEvent()
}
