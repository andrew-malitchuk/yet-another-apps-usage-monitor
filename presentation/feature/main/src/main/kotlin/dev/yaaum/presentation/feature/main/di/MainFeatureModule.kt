package dev.yaaum.presentation.feature.main.di

import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.main.screen.main.MainViewModel
import dev.yaaum.presentation.feature.main.screen.main.mvi.MainMvi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * :presentation:feature:main
 */
val mainFeatureModule = module {
    viewModel { HostViewModel(get()) }
    viewModel {
        MainViewModel(
            getTopAppsWithHighestUsageUseCase = get(),
            getTotalUsageOfAllApplicationUseCase = get(),
            getTotalUsageOfUserApplicationsUseCase = get(),
            getTotalUsageOfChosenApplicationUseCase = get(),
            getGeneralTimeUsageStatisticUseCase = get(),
            getHealthStatusUseCase = get(),
        )
    }
    viewModel {
        MainMvi(
            getTopAppsWithHighestUsageUseCase = get(),
            getHealthStatusUseCase = get(),
            getGeneralTimeUsageStatisticUseCase = get(),
        )
    }
}
