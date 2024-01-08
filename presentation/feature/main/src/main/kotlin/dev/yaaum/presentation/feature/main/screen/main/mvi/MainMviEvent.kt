package dev.yaaum.presentation.feature.main.screen.main.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.models.GeneralTimeUsageStatisticUiModel
import dev.yaaum.presentation.core.models.HealthStatusUiModel
import dev.yaaum.presentation.core.models.TimeUsageUiModel
import dev.yaaum.presentation.core.platform.mvi.event.MviEvent

@Immutable
sealed class MainMviEvent : MviEvent {
    data object UpdateContent : MainMviEvent()
    data object GetMainMviEvent : MainMviEvent()
    data object GetTopAppsUsage : MainMviEvent()
    data object GetHealthStatus : MainMviEvent()
    data object GetGeneralTimeUsage : MainMviEvent()
    data class OnTopAppsUsageFetched(val apps: List<TimeUsageUiModel>?) : MainMviEvent()
    data class OnHealthStatusFetched(val status: HealthStatusUiModel?) : MainMviEvent()
    data class OnGeneralTimeUsageFetched(val timeUsage: GeneralTimeUsageStatisticUiModel?) : MainMviEvent()
}
