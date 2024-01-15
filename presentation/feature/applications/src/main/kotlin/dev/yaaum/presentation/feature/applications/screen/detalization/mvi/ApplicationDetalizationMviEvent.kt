package dev.yaaum.presentation.feature.applications.screen.detalization.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.models.HealthStatusUiModel
import dev.yaaum.presentation.core.models.WeekStatisticUiModel
import dev.yaaum.presentation.core.platform.mvi.event.MviEvent

@Immutable
sealed class ApplicationDetalizationMviEvent : MviEvent {
    data class GetApplicationDetalizationMviEvent(
        val packageName: String,
    ) : ApplicationDetalizationMviEvent()

    data class GetApplicationUsageMviEvent(
        val packageName: String,
    ) : ApplicationDetalizationMviEvent()

    data class ApplicationsFetchedMviEvent(
        val data: ApplicationsUiModel,
        val packageName: String,
    ) : ApplicationDetalizationMviEvent()

    data class ApplicationsDetalizationFetchedMviEvent(
        val weekUsageStatics: WeekStatisticUiModel,
    ) : ApplicationDetalizationMviEvent()

    data class GetApplicationHealthMviEvent(
        val packageName: String,
    ) : ApplicationDetalizationMviEvent()

    data class ApplicationHealthFetchedMviEvent(
        val packageName: String,
        val healthStatusUiModel: HealthStatusUiModel,
    ) : ApplicationDetalizationMviEvent()
}
