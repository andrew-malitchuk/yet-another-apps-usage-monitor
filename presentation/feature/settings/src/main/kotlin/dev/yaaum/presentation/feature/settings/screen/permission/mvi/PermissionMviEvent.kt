package dev.yaaum.presentation.feature.settings.screen.permission.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.event.MviEvent

@Immutable
sealed class PermissionMviEvent : MviEvent {
    data class CheckAppUsagePermissionMviEvent(val isGranted: Boolean) : PermissionMviEvent()
    data class CheckNotificationPermissionMviEvent(val isGranted: Boolean) : PermissionMviEvent()
    data class AppUsagePermissionStateChangedMviEvent(val isGranted: Boolean) : PermissionMviEvent()
    data class NotificationPermissionStateChangedMviEvent(val isGranted: Boolean) : PermissionMviEvent()
}
