package dev.yaaum.presentation.feature.settings.screen.permission.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.state.MviState
import dev.yaaum.presentation.core.ui.error.base.BaseUiError

@Immutable
data class PermissionMviState(
    val loading: Boolean,
    val data: PermissionConfigure?,
    val error: BaseUiError?,
) : MviState {

    companion object {
        fun initial() = PermissionMviState(
            loading = false,
            data = null,
            error = null,
        )

        fun fetched(permissionConfigure: PermissionConfigure) = PermissionMviState(
            loading = false,
            data = permissionConfigure,
            error = null,
        )

        fun error(error: BaseUiError?): PermissionMviState {
            return PermissionMviState(
                loading = false,
                data = null,
                error = error,
            )
        }

        fun loading(): PermissionMviState {
            return PermissionMviState(
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
        return "isLoading: $loading, data: $data, error: $error"
    }
}

data class PermissionConfigure(
    val isNotificationPermissionGranted: Boolean?,
    val isAppUsagePermissionGranted: Boolean?,
)
