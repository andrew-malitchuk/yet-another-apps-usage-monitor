package dev.yaaum.presentation.feature.applications.di

import dev.yaaum.presentation.feature.applications.screen.applications.mvi.ApplicationsMvi
import dev.yaaum.presentation.feature.applications.screen.detalization.mvi.ApplicationDetalizationMvi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * :presentation:feature:applications
 */
val applicationsFeatureModule = module {
    viewModel {
        ApplicationsMvi(
            getAllAppsUseCase = get(),
            filterAllAppsUseCase = get(),
            addAppToChosenUseCase = get(),
            removeAppFromChosenUseCase = get(),
            filterAllApplicationWithChosenUseCase = get(),
        )
    }
    viewModel {
        ApplicationDetalizationMvi(
            getApplicationUseCase = get(),
            getWeekStatisticUseCase = get(),
            getHealthStatusForApplicationUseCase = get(),
        )
    }
}
