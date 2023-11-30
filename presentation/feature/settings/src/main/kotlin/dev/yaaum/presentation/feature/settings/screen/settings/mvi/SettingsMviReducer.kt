package dev.yaaum.presentation.feature.settings.screen.settings.mvi

import dev.yaaum.presentation.core.platform.mvi.MviReducer

class SettingsMviReducer(initial: SettingsMviState) :
    MviReducer<SettingsMviState, SettingsMviEvent>(initial) {
    override fun reduce(oldState: SettingsMviState, event: SettingsMviEvent) {
        when (event) {
            is SettingsMviEvent.ChangeThemeMviEvent -> setState(
                oldState.copy(
                    loading = true,
                    data = event.theme,
                    error = null,
                ),
            )

            SettingsMviEvent.GetThemeMviEvent -> setState(
                oldState.copy(
                    loading = true,
                    data = null,
                    error = null,
                ),
            )

            is SettingsMviEvent.ThemeFetchedMviEvent -> setState(
                oldState.copy(
                    loading = false,
                    data = event.theme,
                    error = null,
                ),
            )
        }
    }
}
