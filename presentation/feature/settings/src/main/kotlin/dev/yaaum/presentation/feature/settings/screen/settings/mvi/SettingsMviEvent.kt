package dev.yaaum.presentation.feature.settings.screen.settings.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.event.MviEvent

@Immutable
sealed class SettingsMviEvent : MviEvent {
    data object GetThemeMviEvent : SettingsMviEvent()
    data class ThemeFetchedMviEvent(val theme: String) : SettingsMviEvent()
    data class ChangeThemeMviEvent(val theme: String) :
        SettingsMviEvent()
}
