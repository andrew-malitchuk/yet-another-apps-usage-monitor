package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.state.MviState
import dev.yaaum.presentation.core.ui.error.base.BaseUiError

@Immutable
data class OnboardingMviState(
    val loading: Boolean,
    val data: List<OnboardingMvi.OnboardingPage>,
    val error: BaseUiError?,
) : MviState {

    companion object {
        fun initial() = OnboardingMviState(
            loading = true,
            data = emptyList(),
            error = null,
        )

        fun error(error: BaseUiError?): OnboardingMviState {
            return OnboardingMviState(
                loading = false,
                data = emptyList(),
                error = error,
            )
        }

        fun loading(): OnboardingMviState {
            return OnboardingMviState(
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
