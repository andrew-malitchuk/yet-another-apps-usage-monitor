package dev.yaaum.presentation.feature.applications.screen.applications.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.domain.core.model.SortOrder
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.platform.mvi.event.MviEvent

@Immutable
sealed class ApplicationsMviEvent : MviEvent {
    data object GetApplicationsMviEvent : ApplicationsMviEvent()

    data class ApplicationsFetchedMviEvent(val data: List<ApplicationsUiModel>) :
        ApplicationsMviEvent()

    data class OnSortChangedMviEvent(val sort: SortOrder? = null) : ApplicationsMviEvent()

    data class OnQueryChangedMviEvent(val query: String? = null) : ApplicationsMviEvent()

    data class OnApplicationStatusChangedEvent(
        val application: ApplicationsUiModel,
        val isChosen: Boolean,
    ) : ApplicationsMviEvent()

    data class ApplicationsUpdatedFetchedMviEvent(
        val application: ApplicationsUiModel,
    ) : ApplicationsMviEvent()
}
