package dev.yaaum.presentation.feature.settings.screen.settings.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.state.MviState
import dev.yaaum.presentation.core.ui.error.base.BaseUiError

@Immutable
data class SettingsMviState(
    val loading: Boolean,
    override val content: SettingsMviContent?,
    val error: BaseUiError?,
) : MviState() {

    companion object {
        fun initial() = SettingsMviState(
            loading = false,
            content = null,
            error = null,
        )

        fun fetched(content: SettingsMviContent) = SettingsMviState(
            loading = false,
            content = content,
            error = null,
        )

        fun error(error: BaseUiError?): SettingsMviState {
            return SettingsMviState(
                loading = false,
                content = null,
                error = error,
            )
        }

        fun loading(): SettingsMviState {
            return SettingsMviState(
                loading = true,
                content = null,
                error = null,
            )
        }
    }

    override val isFetched: Boolean
        get() {
            return content != null && !loading && error == null
        }

    override val isEmpty: Boolean
        get() {
            return content == null && !loading && error == null
        }

    override val isLoading: Boolean
        get() {
            return content == null && loading && error == null
        }

    override val isError: Boolean
        get() {
            return error != null
        }

    override fun toString(): String {
        return "isLoading: $loading, content: $content, error: $error"
    }
}
