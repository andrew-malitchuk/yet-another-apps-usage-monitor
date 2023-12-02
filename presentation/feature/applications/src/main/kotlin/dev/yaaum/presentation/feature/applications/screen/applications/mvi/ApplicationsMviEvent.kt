package dev.yaaum.presentation.feature.applications.screen.applications.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.platform.mvi.event.MviEvent

@Immutable
sealed class ApplicationsMviEvent : MviEvent {
    data object GetApplicationsMviEvent : ApplicationsMviEvent()

    data class ApplicationsFetchedMviEvent(val data: List<ApplicationsUiModel>) :
        ApplicationsMviEvent()
}
