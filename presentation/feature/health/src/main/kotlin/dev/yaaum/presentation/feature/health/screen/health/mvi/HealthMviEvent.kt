package dev.yaaum.presentation.feature.health.screen.health.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.models.GeneralTimeUsageStatisticUiModel
import dev.yaaum.presentation.core.platform.mvi.event.MviEvent

@Immutable
sealed class HealthMviEvent : MviEvent {
    data object GetHealthMviEvent : HealthMviEvent()

    data class ApplicationsFetchedMviEvent(
        val data: List<ApplicationsUiModel>,
    ) : HealthMviEvent()

    data object GetApplicationsHealthMviEvent : HealthMviEvent()

    data class ApplicationsHealthFetchedMviEvent(
        val timeusage: GeneralTimeUsageStatisticUiModel,
    ) : HealthMviEvent()
}
