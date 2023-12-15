package dev.yaaum.presentation.feature.settings.screen.settings.mvi

import arrow.core.raise.recover
import dev.yaaum.domain.configuration.SetThemeUseCase
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.ThemeUiModel
import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import dev.yaaum.presentation.core.ui.error.SwwUiError
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

class SettingsMvi(
    private val setThemeUseCase: SetThemeUseCase,
) : BaseMvi<SettingsMviState, SettingsMviEvent, SettingsMviEffect>() {

    override val state: StateFlow<SettingsMviState>
        get() = reducer.state

    override val effect: SharedFlow<SettingsMviEffect?> = MutableSharedFlow()

    override val reducer = SettingsMviReducer(SettingsMviState.loading())

    var themeStateFlow = MutableSharedFlow<ThemeUiModel>()

    override fun innerEventProcessing(event: SettingsMviEvent) {
        when (event) {
            is SettingsMviEvent.ChangeThemeMviEvent -> updateTheme(event.theme)
            is SettingsMviEvent.GetThemeMviEvent -> getCurrentTheme()
            is SettingsMviEvent.ThemeFetchedMviEvent -> Unit
        }
    }

    private fun updateTheme(theme: String) {
        launch(
            request = {
                recover(
                    {
                        setThemeUseCase(theme)
                        this@SettingsMvi.themeStateFlow.emit(
                            ThemeUiModel.entries.first { it.theme == theme },
                        )
                    },
                    {
                        reducer.setState(
                            SettingsMviState.error(
                                // TODO: fix me
                                SwwUiError(
                                    UiText.DynamicString(it.message ?: ""),
                                    it.throwable,
                                ),
                            ),
                        )
                    },
                )
            },
            errorBlock = {
                reducer.setState(
                    SettingsMviState.error(
                        // TODO: fix me
                        SwwUiError(
                            UiText.DynamicString(it.message ?: ""),
                            it,
                        ),
                    ),
                )
            },
        )
    }

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

    companion object {
        const val ANIMATION_DURATION = 500
    }
}
