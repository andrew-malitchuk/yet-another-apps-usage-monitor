package dev.yaaum.presentation.feature.applications.screen.detalization.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.state.MviState
import dev.yaaum.presentation.core.ui.error.base.BaseUiError

@Immutable
data class ApplicationDetalizationMviState(
    val loading: Boolean,
    override val content: ApplicationDetalizationContent?,
    val error: BaseUiError?,
) : MviState() {

    companion object {
        fun initial() = ApplicationDetalizationMviState(
            loading = true,
            content = null,
            error = null,
        )

        fun fetched(
            content: ApplicationDetalizationContent,
        ) = ApplicationDetalizationMviState(
            loading = false,
            content = content,
            error = null,
        )

        fun error(error: BaseUiError?): ApplicationDetalizationMviState {
            return ApplicationDetalizationMviState(
                loading = false,
                content = null,
                error = error,
            )
        }

        fun loading(): ApplicationDetalizationMviState {
            return ApplicationDetalizationMviState(
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
