package dev.yaaum.presentation.feature.settings.screen.permission.mvi

import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import io.getstream.log.StreamLog
import io.getstream.log.streamLog
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

class PermissionMvi : BaseMvi<PermissionMviState, PermissionMviEvent, PermissionMviEffect>() {

    override val state: StateFlow<PermissionMviState>
        get() = reducer.state

    override val effect: SharedFlow<PermissionMviEffect?> = MutableSharedFlow()

    override val reducer = PermissionMviReducer(PermissionMviState.loading())

    override fun innerEventProcessing(event: PermissionMviEvent) {
        when (event) {
            is PermissionMviEvent.CheckAppUsagePermissionMviEvent -> Unit
            is PermissionMviEvent.CheckNotificationPermissionMviEvent -> Unit
            is PermissionMviEvent.NotificationPermissionStateChangedMviEvent ->
                StreamLog.streamLog {
                    "permission: notification: ${event.isGranted}"
                }

            is PermissionMviEvent.AppUsagePermissionStateChangedMviEvent ->
                StreamLog.streamLog {
                    "permission: appusage: ${event.isGranted}"
                }
        }
    }

    private fun getPermissionState() {
        val notification = false
        val permission = true
        reducer.setState(
            PermissionMviState.fetched(
                PermissionConfigure(
                    isNotificationPermissionGranted = notification,
                    isAppUsagePermissionGranted = permission,
                ),
            ),
        )
    }

    init {
        getPermissionState()
    }
}
