package dev.yaaum.presentation.feature.applications.screen.applications

import androidx.lifecycle.viewModelScope
import arrow.core.raise.fold
import dev.yaaum.domain.applications.AddAppToChosenUseCase
import dev.yaaum.domain.applications.FilterAllApplicationWithChosenUseCase
import dev.yaaum.domain.applications.FilterAllAppsUseCase
import dev.yaaum.domain.applications.GetUserAppsUseCase
import dev.yaaum.domain.applications.RemoveAppFromChosenUseCase
import dev.yaaum.domain.core.model.SortOrder
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.models.toDomainModel
import dev.yaaum.presentation.core.models.toUiModel
import dev.yaaum.presentation.core.platform.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ApplicationsViewModel(
    private val getAllAppsUseCase: GetUserAppsUseCase,
    @Suppress("UnusedPrivateProperty")
    private val filterAllAppsUseCase: FilterAllAppsUseCase,
    private val addAppToChosenUseCase: AddAppToChosenUseCase,
    private val removeAppFromChosenUseCase: RemoveAppFromChosenUseCase,
    private val filterAllApplicationWithChosenUseCase: FilterAllApplicationWithChosenUseCase,
) : BaseViewModel() {

    var applicationStateFlow: StateFlow<List<ApplicationsUiModel>?> = MutableStateFlow(null)
    var areApplicationsLoadingStateFlow: StateFlow<Boolean?> = MutableStateFlow(true)
    var areApplicationsFailedStateFlow: StateFlow<Throwable?> = MutableStateFlow(null)

    var filterFlow: StateFlow<List<ApplicationsUiModel>?> = MutableStateFlow(null)

    // TODO: recode with optics
    val filterQuery: StateFlow<Filter?> = MutableStateFlow(null)

    init {
//        loadApplication()
//        filter()
        viewModelScope.launch {
            filterQuery.collectLatest {
                filter(it?.query, it?.order)
            }
        }
    }

    override fun load() {
        filterQuery.value.let {
            filter(it?.query, it?.order)
        }
    }

    override fun reset() {
        filterQuery.setValue(null)
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

    @Suppress("UnusedParameter")
    fun filter(query: String? = null, order: SortOrder? = null) {
        launch(
            request = {
                filterAllApplicationWithChosenUseCase(
                    query,
                    order ?: SortOrder.ASC,
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

    // TODO: recode with optics
    fun updateFilterQuery(query: String?) {
        viewModelScope.launch {
            (filterQuery as? MutableStateFlow)?.let { state ->
                state.emit(
                    (state.value ?: Filter()).copy(
                        query = query,
                    ),
                )
            }
        }
    }

    // TODO: recode with optics
    fun updateFilterSort(isAsc: Boolean?) {
        viewModelScope.launch {
            (filterQuery as? MutableStateFlow)?.let { state ->
                state.emit(
                    (state.value ?: Filter()).copy(
                        order = if (isAsc == true) {
                            SortOrder.ASC
                        } else {
                            SortOrder.DESC
                        },
                    ),
                )
            }
        }
    }

    fun changeApplicationStatus(application: ApplicationsUiModel, isChosen: Boolean) {
        launch(
            request = {
                arrow.core.raise.recover({
                    if (isChosen) {
                        addAppToChosenUseCase(application.toDomainModel())
                    } else {
                        removeAppFromChosenUseCase(application.toDomainModel())
                    }
                }, {
                    it.toString()
                })
            },
        )
    }

    data class Filter(
        val query: String? = null,
        val order: SortOrder = SortOrder.ASC,
    )
}
