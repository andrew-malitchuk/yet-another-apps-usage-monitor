package dev.yaaum.presentation.feature.main.di

import dev.yaaum.presentation.feature.main.screen.composable.HostViewModel
import dev.yaaum.presentation.feature.main.screen.composable.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * :presentation:feature:main
 */
val mainFeatureModule = module {
    viewModel { HostViewModel(get()) }
    viewModel { MainViewModel() }
}
