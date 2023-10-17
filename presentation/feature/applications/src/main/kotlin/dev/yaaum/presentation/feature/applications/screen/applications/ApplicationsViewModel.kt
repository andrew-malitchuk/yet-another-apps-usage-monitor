package dev.yaaum.presentation.feature.applications.screen.applications

import dev.yaaum.domain.applications.FilterAllAppsUseCase
import dev.yaaum.domain.applications.GetUserAppsUseCase
import dev.yaaum.domain.core.model.SortOrder
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.models.toUiModel
import dev.yaaum.presentation.core.platform.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApplicationsViewModel(
    private val getAllAppsUseCase: GetUserAppsUseCase,
    private val filterAllAppsUseCase: FilterAllAppsUseCase,
) : BaseViewModel() {

    var applicationStateFlow: StateFlow<List<ApplicationsUiModel>?> = MutableStateFlow(null)
    var areApplicationsLoadingStateFlow: StateFlow<Boolean?> = MutableStateFlow(true)
    var areApplicationsFailedStateFlow: StateFlow<Throwable?> = MutableStateFlow(null)

    var filterFlow: StateFlow<List<ApplicationsUiModel>?> = MutableStateFlow(null)

    init {
//        loadApplication()
        filter()
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

    fun filter(query: String? = null, order: SortOrder = SortOrder.ASC) {
        launch(
            request = {
                filterAllAppsUseCase(
                    query,
                    order,
                )
            },
            result = { result ->
                result?.fold(
                    {
                    },
                    { filter ->
                        filterFlow.setValue(
                            filter.map { it.toUiModel() },
                        )
                    },
                )
            },
        )
    }
}
