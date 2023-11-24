package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import dev.yaaum.presentation.core.platform.mvi.MviReducer

class OnboardingReducer(initial: OnboardingMviState) : MviReducer<OnboardingMviState, OnboardingMviEvent>(initial) {
    override fun reduce(oldState: OnboardingMviState, event: OnboardingMviEvent) {
        when (event) {
            is OnboardingMviEvent.GetPagesMviEvent ->
                setState(oldState.copy(loading = false, data = event.data))
        }
    }
}
