package dev.yaaum.presentation.feature.settings.screen.permission.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.state.MviState
import dev.yaaum.presentation.core.ui.error.base.BaseUiError

@Immutable
data class PermissionMviState(
    val loading: Boolean,
    override val content: PermissionMviContent?,
    val error: BaseUiError?,
) : MviState() {

    companion object {
        fun initial() = PermissionMviState(
            loading = false,
            content = null,
            error = null,
        )

        fun fetched(permissionMviContent: PermissionMviContent) = PermissionMviState(
            loading = false,
            content = permissionMviContent,
            error = null,
        )

        fun error(error: BaseUiError?): PermissionMviState {
            return PermissionMviState(
                loading = false,
                content = null,
                error = error,
            )
        }

        fun loading(): PermissionMviState {
            return PermissionMviState(
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

data class PermissionConfigure(
    val isNotificationPermissionGranted: Boolean?,
    val isAppUsagePermissionGranted: Boolean?,
)
