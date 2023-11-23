package dev.yaaum.presentation.core.platform.mvi

import dev.yaaum.presentation.core.platform.mvi.timecapsule.TimeCapsule
import dev.yaaum.presentation.core.platform.mvi.timecapsule.impl.TimeCapsuleImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.android.BuildConfig

abstract class MviReducer<S : MviState, E : MviEvent>(initialVal: S) {

    private val _state: MutableStateFlow<S> = MutableStateFlow(initialVal)
    val state: StateFlow<S>
        get() = _state

    val timeCapsule: TimeCapsule<S> = TimeCapsuleImpl { state ->
        _state.tryEmit(state)
    }

    init {
        timeCapsule.addState(initialVal)
    }

    fun sendEvent(event: E) {
        reduce(_state.value, event)
    }

    fun setState(newState: S) {
        val success = _state.tryEmit(newState)
        // TODO: fix me
        if (BuildConfig.DEBUG && success) {
            timeCapsule.addState(newState)
        }
    }

    abstract fun reduce(oldState: S, event: E)
}
