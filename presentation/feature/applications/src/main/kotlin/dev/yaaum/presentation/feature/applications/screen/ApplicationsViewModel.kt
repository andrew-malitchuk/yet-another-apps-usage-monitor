package dev.yaaum.presentation.feature.applications.screen

import arrow.core.raise.fold
import dev.yaaum.domain.timeusage.GetStatisticsAboutAllAppsUseCase
import dev.yaaum.presentation.core.models.TimeUsageUiModel
import dev.yaaum.presentation.core.models.toUiModel
import dev.yaaum.presentation.core.platform.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ApplicationsViewModel(
    private val getStatisticsAboutAllAppsUseCase: GetStatisticsAboutAllAppsUseCase,
) : BaseViewModel() {

    var applicationStateFlow: StateFlow<List<TimeUsageUiModel>?> = MutableStateFlow(null)
    var areApplicationsLoadingStateFlow: StateFlow<Boolean?> = MutableStateFlow(true)
    var areApplicationsFailedStateFlow: StateFlow<Throwable?> = MutableStateFlow(null)

    init {

        loadApplication()
    }

    fun loadApplication() {
        launch(
            request = {
                getStatisticsAboutAllAppsUseCase()
            },
            result = { result ->
                result?.fold({ error ->
                    areApplicationsFailedStateFlow.setValue(error)
                }, { result ->
                    applicationStateFlow.setValue(result.map { it.toUiModel() })
                })
            },
            loading = {
                areApplicationsLoadingStateFlow.setValue(it)
            },
            errorBlock = {
                areApplicationsFailedStateFlow.setValue(it)
            },
        )
    }
}
