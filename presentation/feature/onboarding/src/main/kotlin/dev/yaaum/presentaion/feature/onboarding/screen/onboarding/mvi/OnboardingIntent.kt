package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import dev.yaaum.presentation.core.platform.mvi.Intent

sealed class OnboardingIntent : Intent() {
    data object GetOnboardingPagesIntent : OnboardingIntent()
}
