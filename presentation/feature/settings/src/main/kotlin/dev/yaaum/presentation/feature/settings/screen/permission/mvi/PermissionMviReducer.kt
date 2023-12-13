package dev.yaaum.presentation.feature.settings.screen.permission.mvi

import dev.yaaum.presentation.core.platform.mvi.MviReducer

class PermissionMviReducer(initial: PermissionMviState) :
    MviReducer<PermissionMviState, PermissionMviEvent>(initial) {
    override fun reduce(oldState: PermissionMviState, event: PermissionMviEvent) {
        when (event) {
            is PermissionMviEvent.CheckAppUsagePermissionMviEvent -> setState(
                oldState.copy(
                    loading = false,
                    content = PermissionMviContent(
                        data = oldState.content?.data?.copy(
                            isAppUsagePermissionGranted = event.isGranted,
                        ),
                    ),
                ),
            )

            is PermissionMviEvent.CheckNotificationPermissionMviEvent -> setState(
                oldState.copy(
                    loading = false,
                    content = PermissionMviContent(
                        data = oldState.content?.data?.copy(
                            isNotificationPermissionGranted = event.isGranted,
                        ),
                    ),
                ),
            )

            is PermissionMviEvent.AppUsagePermissionStateChangedMviEvent -> setState(
                oldState.copy(
                    loading = false,
                    content = PermissionMviContent(
                        data = oldState.content?.data?.copy(
                            isAppUsagePermissionGranted = event.isGranted,
                        ),
                    ),
                ),
            )

            is PermissionMviEvent.NotificationPermissionStateChangedMviEvent -> setState(
                oldState.copy(
                    loading = false,
                    content = PermissionMviContent(
                        data = oldState.content?.data?.copy(
                            isNotificationPermissionGranted = event.isGranted,
                        ),
                    ),
                ),
            )
        }
    }
}
