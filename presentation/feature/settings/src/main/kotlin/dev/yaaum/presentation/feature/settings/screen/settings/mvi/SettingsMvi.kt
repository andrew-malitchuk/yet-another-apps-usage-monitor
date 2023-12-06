package dev.yaaum.presentation.feature.settings.screen.settings.mvi

import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

class SettingsMvi : BaseMvi<SettingsMviState, SettingsMviEvent, SettingsMviEffect>() {

    override val state: StateFlow<SettingsMviState>
        get() = reducer.state

    override val effect: SharedFlow<SettingsMviEffect?> = MutableSharedFlow()

    override val reducer = SettingsMviReducer(SettingsMviState.loading())

    override fun innerEventProcessing(event: SettingsMviEvent) {
        when (event) {
            is SettingsMviEvent.ChangeThemeMviEvent -> setTheme()
            is SettingsMviEvent.GetThemeMviEvent -> getCurrentTheme()
            is SettingsMviEvent.ThemeFetchedMviEvent -> updateTheme(event.theme)
        }
    }

    private fun updateTheme(theme: String) {
        reducer.setState(
            SettingsMviState(
                loading = false,
                content = SettingsMviContent(
                    data = theme,
                ),
                error = null,
            ),
        )
    }

    private fun setTheme() = Unit

    private fun getCurrentTheme() {
        reducer.sendEvent(
            SettingsMviEvent.ThemeFetchedMviEvent(
                "foobar",
            ),
        )
    }

    init {
        getCurrentTheme()
    }
}
