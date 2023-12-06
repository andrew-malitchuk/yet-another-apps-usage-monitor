package dev.yaaum.presentation.feature.settings.screen.settings.mvi

import dev.yaaum.presentation.core.platform.mvi.MviReducer

class SettingsMviReducer(initial: SettingsMviState) :
    MviReducer<SettingsMviState, SettingsMviEvent>(initial) {
    override fun reduce(oldState: SettingsMviState, event: SettingsMviEvent) {
        when (event) {
            is SettingsMviEvent.ChangeThemeMviEvent -> setState(
                oldState.copy(
                    loading = true,
                    content = SettingsMviContent(
                        data = event.theme,
                    ),
                    error = null,
                ),
            )

            SettingsMviEvent.GetThemeMviEvent -> setState(
                oldState.copy(
                    loading = true,
                    content = null,
                    error = null,
                ),
            )

            is SettingsMviEvent.ThemeFetchedMviEvent -> setState(
                oldState.copy(
                    loading = false,
                    content = SettingsMviContent(
                        data = event.theme,
                    ),
                    error = null,
                ),
            )
        }
    }
}
