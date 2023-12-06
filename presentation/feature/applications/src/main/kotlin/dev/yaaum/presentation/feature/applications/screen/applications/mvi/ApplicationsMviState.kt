package dev.yaaum.presentation.feature.applications.screen.applications.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.state.MviState
import dev.yaaum.presentation.core.ui.error.base.BaseUiError

@Immutable
data class ApplicationsMviState(
    val loading: Boolean,
    override val content: ApplicationsMviContent?,
    val error: BaseUiError?,
    val query: String? = null,
) : MviState() {

    companion object {
        fun initial() = ApplicationsMviState(
            loading = true,
            content = null,
            error = null,
        )

        fun fetched(
            content: ApplicationsMviContent?,
            query: String?,
        ) = ApplicationsMviState(
            loading = false,
            content = content,
            error = null,
            query = query,
        )

        fun error(error: BaseUiError?): ApplicationsMviState {
            return ApplicationsMviState(
                loading = false,
                content = null,
                error = error,
            )
        }

        fun loading(): ApplicationsMviState {
            return ApplicationsMviState(
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
