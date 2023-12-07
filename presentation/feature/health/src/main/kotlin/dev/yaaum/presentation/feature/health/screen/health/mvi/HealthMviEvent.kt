package dev.yaaum.presentation.feature.health.screen.health.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.event.MviEvent

@Immutable
sealed class HealthMviEvent : MviEvent {
    data object GetHealthMviEvent : HealthMviEvent()

    data class ApplicationsFetchedMviEvent(
        val message: String,
    ) : HealthMviEvent()
}
