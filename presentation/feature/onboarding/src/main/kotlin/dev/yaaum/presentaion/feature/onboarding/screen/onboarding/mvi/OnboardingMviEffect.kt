package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import dev.yaaum.presentation.core.platform.mvi.effect.MviEffect

sealed class OnboardingMviEffect : MviEffect {
    /**
     * Specify transition from onboarding screen to main
     */
    data object GoToMainScreenMviEffect : OnboardingMviEffect()
}
