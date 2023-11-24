package dev.yaaum.presentation.feature.health.screen.health

import dev.yaaum.domain.applications.GetUserAppsUseCase
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.models.toUiModel
import dev.yaaum.presentation.core.platform.vm.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HealthViewModel(
    private val getAllAppsUseCase: GetUserAppsUseCase,
) : BaseViewModel() {

    var applicationStateFlow: StateFlow<List<ApplicationsUiModel>?> = MutableStateFlow(null)
    var areApplicationsLoadingStateFlow: StateFlow<Boolean?> = MutableStateFlow(true)
    var areApplicationsFailedStateFlow: StateFlow<Throwable?> = MutableStateFlow(null)

    override fun load() {
        loadApplication()
    }

    fun loadApplication() {
        launch(
            request = {
                getAllAppsUseCase()
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
