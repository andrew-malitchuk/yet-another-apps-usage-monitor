package dev.yaaum.presentation.feature.health.screen.health.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.state.MviState
import dev.yaaum.presentation.core.ui.error.base.BaseUiError

@Immutable
data class HealthMviState(
    val loading: Boolean,
    override val content: HealthMviContent?,
    val error: BaseUiError?,
) : MviState() {

    companion object {
        fun initial() = HealthMviState(
            loading = true,
            content = null,
            error = null,
        )

        fun fetched(
            content: HealthMviContent,
        ) = HealthMviState(
            loading = false,
            content = content,
            error = null,
        )

        fun error(error: BaseUiError?): HealthMviState {
            return HealthMviState(
                loading = false,
                content = null,
                error = error,
            )
        }

        fun loading(): HealthMviState {
            return HealthMviState(
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
