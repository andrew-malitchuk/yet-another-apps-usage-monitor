package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import dev.yaaum.presentation.core.platform.mvi.effect.MviEffect

sealed class OnboardingMviEffect : MviEffect {
    data object GoToMainScreenMviEffect : OnboardingMviEffect()
}
