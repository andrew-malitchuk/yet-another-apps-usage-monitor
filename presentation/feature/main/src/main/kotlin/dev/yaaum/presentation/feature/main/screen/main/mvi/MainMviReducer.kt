package dev.yaaum.presentation.feature.main.screen.main.mvi

import dev.yaaum.presentation.core.platform.mvi.MviReducer

class MainMviReducer(initial: MainMviState) :
    MviReducer<MainMviState, MainMviEvent>(initial) {
    override fun reduce(oldState: MainMviState, event: MainMviEvent) {
        when (event) {
            is MainMviEvent.GetMainMviEvent -> setState(
                oldState.copy(
                    loading = false,
                    content = MainMviContent(
                        data = null,
                    ),
                    error = null,
                    query = null,
                ),
            )
        }
    }
}
