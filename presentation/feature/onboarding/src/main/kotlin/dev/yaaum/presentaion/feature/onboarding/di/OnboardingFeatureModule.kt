package dev.yaaum.presentaion.feature.onboarding.di

import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.OnboardingViewModel
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi.FooMvi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * :presentation:feature:onboarding
 */
val onboardingFeatureModule = module {
    viewModel {
        OnboardingViewModel(
            setOnboardingFinishedUseCase = get(),
        )
    }
    viewModel {
        FooMvi()
    }
}
