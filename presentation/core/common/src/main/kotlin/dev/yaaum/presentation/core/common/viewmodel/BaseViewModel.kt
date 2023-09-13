package dev.yaaum.presentation.core.common.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.yaaum.core.common.coroutines.flatMapConcurrently
import dev.yaaum.presentation.core.common.mvi.BaseUiEvent
import dev.yaaum.presentation.core.common.mvi.BaseUiIntent
import dev.yaaum.presentation.core.common.mvi.BaseUiState
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onSubscription
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.launch

abstract class BaseViewModel<
    UiState : BaseUiState,
    PartialUiState : BaseUiState,
    UiEvent : BaseUiEvent,
    UiIntent : BaseUiIntent,
    >(savedStateHandle: SavedStateHandle, initialState: UiState) : ViewModel() {

    private val intentsFlowListenerStarted = CompletableDeferred<Unit>()
    private val changesPartialStateFlowListenerStarted = CompletableDeferred<Unit>()

    private val intentsFlow = MutableSharedFlow<UiIntent>()
    private val changesPartialStateFlow = MutableSharedFlow<PartialUiState>()

    val uiState = savedStateHandle.getStateFlow(SAVED_UI_STATE_KEY, initialState)

    private val eventChannel = Channel<UiEvent>(Channel.BUFFERED)
    val event = eventChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            merge(
                userIntents(),
                nonUserChanges(),
            )
                .scan(uiState.value, ::reduceUiState)
//                .catch { Timber.e(it) }
                .collect {
                    savedStateHandle[SAVED_UI_STATE_KEY] = it
                }
        }
    }

    private fun userIntents(): Flow<PartialUiState> =
        intentsFlow
            .onSubscription { intentsFlowListenerStarted.complete(Unit) }
            .flatMapConcurrently(
                transform = ::mapIntents,
            )

    private fun nonUserChanges(): Flow<PartialUiState> =
        changesPartialStateFlow
            .onSubscription { changesPartialStateFlowListenerStarted.complete(Unit) }

    fun acceptIntent(intent: UiIntent) {
        viewModelScope.launch {
            intentsFlowListenerStarted.await()
            intentsFlow.emit(intent)
        }
    }

    protected fun acceptChanges(vararg nonUserChangesFlows: Flow<PartialUiState>) {
        viewModelScope.launch {
            changesPartialStateFlowListenerStarted.await()
            changesPartialStateFlow.emitAll(
                // to flatten Flow with queue behaviour like in userIntents() Flow but without ::mapIntents
                nonUserChangesFlows.asFlow().flatMapConcurrently { it },
            )
        }
    }

    protected fun publishEvent(event: UiEvent) {
        viewModelScope.launch {
            eventChannel.send(event)
        }
    }

    protected abstract fun mapIntents(intent: UiIntent): Flow<PartialUiState>

    protected abstract fun reduceUiState(
        previousState: UiState,
        partialState: PartialUiState,
    ): UiState

    companion object {
        const val SAVED_UI_STATE_KEY = "savedUiStateKey"
    }
}
