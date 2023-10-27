package dev.yaaum.presentation.feature.health.di

import dev.yaaum.presentation.feature.health.screen.health.HealthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * :presentation:feature:health
 */
val healthFeatureModule = module {
    viewModel {
        HealthViewModel(
            getAllAppsUseCase = get(),
        )
    }
}
