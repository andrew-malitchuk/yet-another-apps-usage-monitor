package dev.yaaum.presentation.feature.settings.screen.permission.mvi

import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

class PermissionMvi : BaseMvi<PermissionMviState, PermissionMviEvent, PermissionMviEffect>() {

    override val state: StateFlow<PermissionMviState>
        get() = reducer.state

    override val effect: SharedFlow<PermissionMviEffect?> = MutableSharedFlow()

    override val reducer = PermissionMviReducer(PermissionMviState.initial())

    override fun innerEventProcessing(event: PermissionMviEvent) {
        when (event) {
            is PermissionMviEvent.NotificationPermissionStateChangedMviEvent -> Unit

            is PermissionMviEvent.AppUsagePermissionStateChangedMviEvent -> Unit

            PermissionMviEvent.CheckPermissionsMviEvent -> Unit
        }
    }
}
