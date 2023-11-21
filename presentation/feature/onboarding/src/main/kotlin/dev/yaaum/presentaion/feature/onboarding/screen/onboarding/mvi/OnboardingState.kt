package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import dev.yaaum.presentation.core.platform.mvi.State

class OnboardingState<T : List<FooViewModel.OnboardingPage>> : State<T>() {
    override val isLoading: Boolean = false
    override val error: Throwable? = null
    override val data: T? = null
}
