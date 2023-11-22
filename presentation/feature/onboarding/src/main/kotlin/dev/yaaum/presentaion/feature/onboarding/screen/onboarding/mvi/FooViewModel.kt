package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import androidx.lifecycle.SavedStateHandle
import dev.yaaum.presentation.core.platform.mvi.Mvi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FooViewModel(
    savedStateHandle: SavedStateHandle,
    initialState: OnboardingState,
) : Mvi<OnboardingState, OnboardingState.PartialState, OnboardingEffect, OnboardingEvent>(
    savedStateHandle,
    initialState,
) {
    init {
        observeFoo()
    }

    override fun mapIntents(intent: OnboardingEvent): Flow<OnboardingState.PartialState> =
        when (intent) {
            is OnboardingEvent.GetPagesOnboardingEvent -> foo()
        }

    override fun reduceUiState(
        previousState: OnboardingState,
        partialState: OnboardingState.PartialState,
    ): OnboardingState = when (partialState) {
        is OnboardingState.PartialState.Loading -> previousState.copy(
            isLoading = true,
            isError = false,
        )

        is OnboardingState.PartialState.Fetched -> previousState.copy(
            isLoading = false,
            data = partialState.data,
            isError = false,
        )

        else -> previousState.copy(
            isLoading = false,
            isError = true,
        )
    }

    private fun observeFoo() = acceptChanges()

    private fun foo(): Flow<OnboardingState.PartialState> = flow {
        emit(
            OnboardingState.PartialState.Fetched(
                data = listOf("foo"),
            ),
        )
    }
}
