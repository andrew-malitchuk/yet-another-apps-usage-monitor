package dev.yaaum.presentation.feature.main.screen.main.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.state.MviState
import dev.yaaum.presentation.core.ui.error.base.BaseUiError

@Immutable
data class MainMviState(
    val loading: Boolean,
    override val content: MainMviContent?,
    val error: BaseUiError?,
) : MviState() {

    companion object {
        fun initial() = MainMviState(
            loading = true,
            content = null,
            error = null,
        )

        fun fetched(
            content: MainMviContent?,
        ) = MainMviState(
            loading = false,
            content = content,
            error = null,
        )

        fun error(error: BaseUiError?): MainMviState {
            return MainMviState(
                loading = false,
                content = null,
                error = error,
            )
        }

        fun loading(): MainMviState {
            return MainMviState(
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
