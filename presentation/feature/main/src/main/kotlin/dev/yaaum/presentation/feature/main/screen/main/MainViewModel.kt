package dev.yaaum.presentation.feature.main.screen.main

import dev.yaaum.domain.health.GetGeneralTimeUsageStatisticUseCase
import dev.yaaum.domain.health.GetHealthStatusUseCase
import dev.yaaum.domain.timeusage.GetTopAppsWithHighestUsageUseCase
import dev.yaaum.domain.timeusage.GetTotalUsageOfAllApplicationUseCase
import dev.yaaum.domain.timeusage.GetTotalUsageOfChosenApplicationUseCase
import dev.yaaum.domain.timeusage.GetTotalUsageOfUserApplicationsUseCase
import dev.yaaum.presentation.core.models.TimeUsageUiModel
import dev.yaaum.presentation.core.models.toUiModel
import dev.yaaum.presentation.core.platform.vm.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val getTopAppsWithHighestUsageUseCase: GetTopAppsWithHighestUsageUseCase,
    private val getTotalUsageOfAllApplicationUseCase: GetTotalUsageOfAllApplicationUseCase,
    private val getTotalUsageOfUserApplicationsUseCase: GetTotalUsageOfUserApplicationsUseCase,
    private val getTotalUsageOfChosenApplicationUseCase: GetTotalUsageOfChosenApplicationUseCase,
    private val getGeneralTimeUsageStatisticUseCase: GetGeneralTimeUsageStatisticUseCase,
    private val getHealthStatusUseCase: GetHealthStatusUseCase,
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
                getTotalUsageOfAllApplicationUseCase(0L, 0L)
                getTotalUsageOfUserApplicationsUseCase(0L, 0L)
                getTotalUsageOfChosenApplicationUseCase(0L, 0L)
                getGeneralTimeUsageStatisticUseCase(0L, 0L)
                getHealthStatusUseCase(0L, 0L)
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
