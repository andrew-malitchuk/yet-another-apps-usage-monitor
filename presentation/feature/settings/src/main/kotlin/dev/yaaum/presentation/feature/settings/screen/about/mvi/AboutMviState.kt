package dev.yaaum.presentation.feature.settings.screen.about.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.state.MviState

@Immutable
class AboutMviState : MviState() {

    companion object {
        fun initial() = AboutMviState()
    }

    override val content = AboutMviContent()

    override val isFetched: Boolean
        get() {
            return true
        }

    override val isEmpty: Boolean
        get() {
            return false
        }

    override val isLoading: Boolean
        get() {
            return false
        }

    override val isError: Boolean
        get() {
            return false
        }
}
