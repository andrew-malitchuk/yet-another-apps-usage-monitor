package dev.yaaum.presentation.feature.applications.screen.detalization.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.platform.mvi.state.MviState
import dev.yaaum.presentation.core.ui.error.base.BaseUiError

@Immutable
data class ApplicationDetalizationMviState(
    val loading: Boolean,
    val data: ApplicationsUiModel?,
    val error: BaseUiError?,
) : MviState {

    companion object {
        fun initial() = ApplicationDetalizationMviState(
            loading = true,
            data = null,
            error = null,
        )

        fun fetched(
            data: ApplicationsUiModel,
        ) = ApplicationDetalizationMviState(
            loading = false,
            data = data,
            error = null,
        )

        fun error(error: BaseUiError?): ApplicationDetalizationMviState {
            return ApplicationDetalizationMviState(
                loading = false,
                data = null,
                error = error,
            )
        }

        fun loading(): ApplicationDetalizationMviState {
            return ApplicationDetalizationMviState(
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
