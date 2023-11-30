package dev.yaaum.presentation.feature.settings.di

import dev.yaaum.presentation.feature.settings.screen.about.mvi.AboutMvi
import dev.yaaum.presentation.feature.settings.screen.permission.PermissionViewModel
import dev.yaaum.presentation.feature.settings.screen.settings.mvi.SettingsMvi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * `:presentation:feature:settings`
 */
val settingsFeatureModule = module {
    viewModel {
        SettingsMvi()
    }
    viewModel {
        AboutMvi()
    }
    viewModel {
        PermissionViewModel()
    }
}
