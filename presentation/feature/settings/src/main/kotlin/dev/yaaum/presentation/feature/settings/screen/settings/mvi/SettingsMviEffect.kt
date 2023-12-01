package dev.yaaum.presentation.feature.settings.screen.settings.mvi

import dev.yaaum.presentation.core.platform.mvi.effect.MviEffect

sealed class SettingsMviEffect : MviEffect {
    /**
     * Specify transition from settings to info
     */
    data object GoToInfoScreenMviEffect : SettingsMviEffect()

    /**
     * Specify transition from settings to language
     */
    data object GoToLanguageScreenMviEffect : SettingsMviEffect()

    /**
     * Specify transition from settings to permissions
     */
    data object GoToPermissionsScreenMviEffect : SettingsMviEffect()
}
