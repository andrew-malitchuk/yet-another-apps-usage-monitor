package dev.yaaum.presentation.feature.health.di

import dev.yaaum.presentation.feature.health.screen.health.mvi.HealthMvi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * :presentation:feature:health
 */
val healthFeatureModule = module {
    viewModel {
        HealthMvi(
            getAllAppsUseCase = get(),
            getGeneralTimeUsageStatisticUseCase = get(),
            getRateUseCase = get(),
        )
    }
}
