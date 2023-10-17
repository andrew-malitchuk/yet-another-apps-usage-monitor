package dev.yaaum.presentation.feature.applications.di

import dev.yaaum.presentation.feature.applications.screen.applications.ApplicationsViewModel
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
        )
    }
}
