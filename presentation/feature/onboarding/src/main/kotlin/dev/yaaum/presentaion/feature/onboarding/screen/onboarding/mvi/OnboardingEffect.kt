package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import dev.yaaum.presentation.core.platform.mvi.Effect

sealed class OnboardingEffect : Effect() {
    data object GoToMain : OnboardingEffect()
}
