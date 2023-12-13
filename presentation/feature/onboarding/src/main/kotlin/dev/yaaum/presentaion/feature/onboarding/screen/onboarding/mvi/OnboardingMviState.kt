package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import androidx.compose.runtime.Immutable
import dev.yaaum.presentation.core.platform.mvi.state.MviState
import dev.yaaum.presentation.core.ui.error.base.BaseUiError

@Immutable
data class OnboardingMviState(
    val loading: Boolean,
    override val content: OnboardingMviContent?,
    val error: BaseUiError?,
) : MviState() {

    companion object {
        fun initial() = OnboardingMviState(
            loading = true,
            content = null,
            error = null,
        )

        fun error(error: BaseUiError?): OnboardingMviState {
            return OnboardingMviState(
                loading = false,
                content = null,
                error = error,
            )
        }

        fun loading(): OnboardingMviState {
            return OnboardingMviState(
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
