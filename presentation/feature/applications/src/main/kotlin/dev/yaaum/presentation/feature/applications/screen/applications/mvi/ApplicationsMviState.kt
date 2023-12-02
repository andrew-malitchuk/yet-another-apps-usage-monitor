package dev.yaaum.presentation.feature.applications.screen.applications.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.platform.mvi.state.MviState
import dev.yaaum.presentation.core.ui.error.base.BaseUiError

@Immutable
data class ApplicationsMviState(
    val loading: Boolean,
    val data: List<ApplicationsUiModel>,
    val error: BaseUiError?,
) : MviState {

    companion object {
        fun initial() = ApplicationsMviState(
            loading = true,
            data = emptyList(),
            error = null,
        )

        fun fetched(data: List<ApplicationsUiModel>) = ApplicationsMviState(
            loading = false,
            data = data,
            error = null,
        )

        fun error(error: BaseUiError?): ApplicationsMviState {
            return ApplicationsMviState(
                loading = false,
                data = emptyList(),
                error = error,
            )
        }

        fun loading(): ApplicationsMviState {
            return ApplicationsMviState(
                loading = true,
                data = emptyList(),
                error = null,
            )
        }
    }

    override val isFetched: Boolean
        get() {
            return data.isNotEmpty() && !loading && error == null
        }

    override val isEmpty: Boolean
        get() {
            return data.isEmpty() && !loading && error == null
        }

    override val isLoading: Boolean
        get() {
            return data.isEmpty() && loading && error == null
        }

    override val isError: Boolean
        get() {
            return error != null
        }

    override fun toString(): String {
        return "isLoading: $loading, data.size: ${data.size}, error: $error"
    }
}
