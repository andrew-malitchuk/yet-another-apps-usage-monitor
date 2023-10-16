package dev.yaaum.presentaion.feature.statistics.di

import dev.yaaum.presentaion.feature.statistics.screen.permissions.PermissionsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * :presentation:feature:onboarding
 */
val statisticsFeatureModule = module {
    viewModel {
        PermissionsViewModel()
    }
}
