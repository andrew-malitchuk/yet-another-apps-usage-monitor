package dev.yaaum.presentation.feature.settings.screen.settings.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.state.MviState
import dev.yaaum.presentation.core.ui.error.base.BaseUiError

@Immutable
data class SettingsMviState(
    val loading: Boolean,
    val data: String?,
    val error: BaseUiError?,
) : MviState {

    companion object {
        fun initial() = SettingsMviState(
            loading = false,
            data = null,
            error = null,
        )

        fun fetched(theme: String) = SettingsMviState(
            loading = false,
            data = theme,
            error = null,
        )

        fun error(error: BaseUiError?): SettingsMviState {
            return SettingsMviState(
                loading = false,
                data = null,
                error = error,
            )
        }

        fun loading(): SettingsMviState {
            return SettingsMviState(
                loading = true,
                data = null,
                error = null,
            )
        }
    }

    override val isFetched: Boolean
        get() {
            return data != null && !loading && error == null
        }

    override val isEmpty: Boolean
        get() {
            return data == null && !loading && error == null
        }

    override val isLoading: Boolean
        get() {
            return data == null && loading && error == null
        }

    override val isError: Boolean
        get() {
            return error != null
        }

    override fun toString(): String {
        return "isLoading: $loading, data.size: $data, error: $error"
    }
}
