package dev.yaaum.presentation.feature.settings.screen.about.mvi

import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import dev.yaaum.presentation.core.platform.mvi.MviReducer
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

class AboutMvi : BaseMvi<AboutMviState, AboutMviEvent, AboutMviEffect>() {

    override val state: StateFlow<AboutMviState>
        get() = reducer.state

    override val effect: SharedFlow<AboutMviEffect?> = MutableSharedFlow()

    override val reducer: MviReducer<AboutMviState, AboutMviEvent> =
        AboutMviReducer(AboutMviState.initial())

    companion object {
        const val GITHUB_URL = "https://github.com/andrew-malitchuk/yet-another-apps-usage-monitor"
    }
}
