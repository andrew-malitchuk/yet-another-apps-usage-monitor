package dev.yaaum.presentation.core.platform.mvi.state

import dev.yaaum.presentation.core.platform.mvi.MviPartialState
import dev.yaaum.presentation.core.platform.mvi.state.content.MviContent

/**
 * Declare top-hierarchy for ui-state
 */
abstract class MviState {

    abstract val content: MviContent?

    val partialState: MviPartialState
        get() {
            return when {
                isEmpty ->
                    MviPartialState.EMPTY

                isLoading -> MviPartialState.LOADING

                isError -> MviPartialState.ERROR
                else ->
                    MviPartialState.FETCHED
            }
        }

    abstract val isFetched: Boolean
    abstract val isEmpty: Boolean
    abstract val isLoading: Boolean
    abstract val isError: Boolean
}
