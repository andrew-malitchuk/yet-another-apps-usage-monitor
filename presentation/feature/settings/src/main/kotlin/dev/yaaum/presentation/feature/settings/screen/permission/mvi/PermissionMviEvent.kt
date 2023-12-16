package dev.yaaum.presentation.feature.settings.screen.permission.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.event.MviEvent

@Immutable
sealed class PermissionMviEvent : MviEvent {
    /**
     * Triggered on the screen start; launch permission checks
     */
    data object CheckPermissionsMviEvent : PermissionMviEvent()

    data class AppUsagePermissionStateChangedMviEvent(val isGranted: Boolean) : PermissionMviEvent()
    data class NotificationPermissionStateChangedMviEvent(val isGranted: Boolean) : PermissionMviEvent()
}
