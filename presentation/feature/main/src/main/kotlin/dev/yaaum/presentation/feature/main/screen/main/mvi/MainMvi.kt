package dev.yaaum.presentation.feature.main.screen.main.mvi

import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

@Suppress("Unused", "UnusedPrivateProperty")
class MainMvi : BaseMvi<MainMviState, MainMviEvent, MainMviEffect>() {

    override val state: StateFlow<MainMviState>
        get() = reducer.state

    override val effect: SharedFlow<MainMviEffect?> = MutableSharedFlow()

    override val reducer = MainMviReducer(MainMviState.initial())

    private var searchJob: Job? = null

    override fun innerEventProcessing(event: MainMviEvent) {
        when (event) {
            MainMviEvent.GetMainMviEvent -> Unit
        }
    }
}
