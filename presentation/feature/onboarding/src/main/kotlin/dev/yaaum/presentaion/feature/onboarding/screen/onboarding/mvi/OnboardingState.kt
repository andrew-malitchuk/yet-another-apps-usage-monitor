package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import dev.yaaum.presentation.core.platform.mvi.Fetched
import dev.yaaum.presentation.core.platform.mvi.Loading
import dev.yaaum.presentation.core.platform.mvi.State

interface OnboardingState : State

class OnboardingFetched<T : List<FooViewModel.OnboardingPage>>(
    override val content: T,
) : OnboardingState, Fetched<T>(content)

class OnboardingLoading : OnboardingState, Loading()
