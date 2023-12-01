package dev.yaaum.presentation.feature.settings.screen.permission.mvi

import dev.yaaum.presentation.core.platform.mvi.effect.MviEffect

sealed class PermissionMviEffect : MviEffect {
    /**
     * Specify transition from permissions to info
     */
    data object GoToInfoScreenMviEffect : PermissionMviEffect()

    /**
     * Launch notification checker
     */
    data object LaunchNotificationPermissionMviEffect : PermissionMviEffect()

    /**
     * Open settings to check app's usage permission
     */
    data object LaunchAppUsagePermissionMviEffect : PermissionMviEffect()
}
