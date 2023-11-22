package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class OnboardingState(
    val isLoading: Boolean = false,
    val data: List<String> = emptyList(),
    val isError: Boolean = false,
) : Parcelable {

    sealed class PartialState {
        data object Loading : PartialState()
        data class Fetched(val data: List<String>) : PartialState()
        data class Error(val throwable: Throwable) : PartialState()
        data object Empty : PartialState()
    }
}
