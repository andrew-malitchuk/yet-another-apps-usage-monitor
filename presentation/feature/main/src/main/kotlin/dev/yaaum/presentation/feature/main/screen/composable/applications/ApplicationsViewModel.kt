package dev.yaaum.presentation.feature.main.screen.composable.applications

import dev.yaaum.domain.timeusage.GetStatisticsAboutAllAppsUseCase
import dev.yaaum.presentation.core.platform.viewmodel.BaseViewModel

@Suppress("unused")
class ApplicationsViewModel(
    private val getStatisticsAboutAllAppsUseCase: GetStatisticsAboutAllAppsUseCase,
) : BaseViewModel()
