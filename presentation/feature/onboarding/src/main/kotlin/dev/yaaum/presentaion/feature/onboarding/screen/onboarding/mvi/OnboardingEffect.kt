package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

sealed class OnboardingEffect : Effect {
    data class GoToMainOnboardingEffect : OnboardingEffect()
}
