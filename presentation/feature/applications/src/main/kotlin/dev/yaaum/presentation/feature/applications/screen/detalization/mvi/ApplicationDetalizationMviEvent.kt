package dev.yaaum.presentation.feature.applications.screen.detalization.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.platform.mvi.event.MviEvent

@Immutable
sealed class ApplicationDetalizationMviEvent : MviEvent {
    data class GetApplicationDetalizationMviEvent(
        val packageName: String,
    ) : ApplicationDetalizationMviEvent()

    data class ApplicationsFetchedMviEvent(
        val data: ApplicationsUiModel,
        val packageName: String,
    ) : ApplicationDetalizationMviEvent()
}
