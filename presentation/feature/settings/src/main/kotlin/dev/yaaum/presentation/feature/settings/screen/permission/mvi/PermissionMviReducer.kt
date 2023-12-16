package dev.yaaum.presentation.feature.settings.screen.permission.mvi

import dev.yaaum.presentation.core.platform.mvi.MviReducer

class PermissionMviReducer(initial: PermissionMviState) :
    MviReducer<PermissionMviState, PermissionMviEvent>(initial) {
    override fun reduce(oldState: PermissionMviState, event: PermissionMviEvent) {
        when (event) {
            is PermissionMviEvent.AppUsagePermissionStateChangedMviEvent -> {
                val tempContent = oldState.content ?: PermissionMviContent(PermissionConfigure())
                setState(
                    oldState.copy(
                        loading = false,
                        content = PermissionMviContent(
                            data = tempContent.data?.copy(
                                isAppUsagePermissionGranted = event.isGranted,
                                isNotificationPermissionGranted = true,
                            ),
                        ),
                        error = null,
                    ),
                )
            }

            is PermissionMviEvent.NotificationPermissionStateChangedMviEvent -> setState(
                oldState.copy(
                    loading = false,
                    content = PermissionMviContent(
                        data = oldState.content?.data?.copy(
                            isNotificationPermissionGranted = event.isGranted,
                        ),
                    ),
                    error = null,
                ),
            )

            PermissionMviEvent.CheckPermissionsMviEvent -> setState(
                oldState.copy(
                    loading = false,
                    content = null,
                    error = null,
                ),
            )
        }
    }
}
