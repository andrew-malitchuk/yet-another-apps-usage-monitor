package dev.yaaum.presentation.core.platform.mvi.state

import dev.yaaum.presentation.core.platform.mvi.MviPartialState

/**
 * Declare top-hierarchy for ui-state
 */
interface MviState {

    val partialState: MviPartialState
        get() {
            return when {
                isFetched ->
                    MviPartialState.FETCHED

                isEmpty ->
                    MviPartialState.EMPTY

                isLoading -> MviPartialState.LOADING

                else ->
                    MviPartialState.ERROR
            }
        }

    val isFetched: Boolean
    val isEmpty: Boolean
    val isLoading: Boolean
    val isError: Boolean
}
