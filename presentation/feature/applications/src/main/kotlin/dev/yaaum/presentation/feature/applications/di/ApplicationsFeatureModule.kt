package dev.yaaum.presentation.feature.applications.di

import dev.yaaum.presentation.feature.applications.screen.applications.ApplicationsViewModel
import dev.yaaum.presentation.feature.applications.screen.detalization.ApplicationDetalizationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * :presentation:feature:applications
 */
val applicationsFeatureModule = module {
    viewModel {
        ApplicationsViewModel(
            getAllAppsUseCase = get(),
            filterAllAppsUseCase = get(),
            addAppToChosenUseCase = get(),
            removeAppFromChosenUseCase = get(),
            filterAllApplicationWithChosenUseCase = get(),
        )
    }
    viewModel {
        ApplicationDetalizationViewModel()
    }
}
