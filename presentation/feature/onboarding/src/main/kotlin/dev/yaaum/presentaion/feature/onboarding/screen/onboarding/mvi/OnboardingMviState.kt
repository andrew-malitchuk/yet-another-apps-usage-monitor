package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.common.core.error.base.BaseError
import dev.yaaum.presentation.core.platform.mvi.state.MviState

@Immutable
data class OnboardingMviState(
    val loading: Boolean,
    val data: List<OnboardingMvi.OnboardingPage>,
    val error: BaseError?,
) : MviState {

    companion object {
        fun initial() = OnboardingMviState(
            loading = true,
            data = emptyList(),
            error = null,
        )
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
