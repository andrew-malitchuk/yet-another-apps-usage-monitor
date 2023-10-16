package dev.yaaum.presentation.feature.main.screen.main

import dev.yaaum.domain.timeusage.GetTopAppsWithHighestUsageUseCase
import dev.yaaum.presentation.core.models.TimeUsageUiModel
import dev.yaaum.presentation.core.models.toUiModel
import dev.yaaum.presentation.core.platform.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val getTopAppsWithHighestUsageUseCase: GetTopAppsWithHighestUsageUseCase,
) : BaseViewModel() {

    var topAppsWithHighestUsageStateFlow: StateFlow<List<TimeUsageUiModel>?> =
        MutableStateFlow(null)
    var areTopAppsWithHighestUsageLoadingStateFlow: StateFlow<Boolean?> = MutableStateFlow(true)
    var areTopAppsWithHighestUsageFailedStateFlow: StateFlow<Throwable?> = MutableStateFlow(null)

    init {
        loadTopAppsWithHighestUsage()
    }

    private fun loadTopAppsWithHighestUsage() {
        launch(
            request = {
                getTopAppsWithHighestUsageUseCase(TOP_APPS_COUNT)
            },
            result = { result ->
                result?.fold({ error ->
                    areTopAppsWithHighestUsageFailedStateFlow.setValue(error)
                }, { result ->
                    topAppsWithHighestUsageStateFlow.setValue(result.map { it.toUiModel() })
                })
            },
            loading = {
                areTopAppsWithHighestUsageLoadingStateFlow.setValue(it)
            },
            errorBlock = {
                areTopAppsWithHighestUsageFailedStateFlow.setValue(it)
            },
        )
    }

    companion object {
        const val TOP_APPS_COUNT = 3
    }
}
