package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import dev.yaaum.presentation.core.platform.mvi.Effect
import dev.yaaum.presentation.core.platform.mvi.Event
import dev.yaaum.presentation.core.platform.mvi.State

class FooContract {

    sealed class FooEvent : Event() {
        data object OnRandomNumberClicked : FooEvent()
        data object OnShowToastClicked : FooEvent()
    }

    data class FooState(
        val state: RandomNumberState,
    ) : State()

    sealed class RandomNumberState {
        data object Idle : RandomNumberState()
        data object Loading : RandomNumberState()
        data class Fetched(val number: Int) : RandomNumberState()
        data class Error(val throwable: Throwable) : RandomNumberState()
    }

    sealed class FooEffect : Effect() {
        data object ShowToast : FooEffect()
    }
}
