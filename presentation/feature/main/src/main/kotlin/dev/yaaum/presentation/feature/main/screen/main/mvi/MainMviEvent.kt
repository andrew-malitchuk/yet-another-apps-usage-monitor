package dev.yaaum.presentation.feature.main.screen.main.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.event.MviEvent

@Immutable
sealed class MainMviEvent : MviEvent {
    data object GetMainMviEvent : MainMviEvent()
}
