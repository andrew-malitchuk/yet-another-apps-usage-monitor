package dev.yaaum.presentation.feature.settings.screen.permission.mvi

import dev.yaaum.presentation.core.platform.mvi.effect.MviEffect

sealed class PermissionMviEffect : MviEffect {

    /**
     * Launch notification checker
     */
    data object LaunchNotificationPermissionMviEffect : PermissionMviEffect()

    /**
     * Open settings to check app's usage permission
     */
    data object LaunchAppUsagePermissionMviEffect : PermissionMviEffect()
}
