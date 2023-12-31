package dev.yaaum.presentation.feature.health.screen.health.mvi

import dev.yaaum.presentation.core.platform.mvi.MviReducer

class HealthMviReducer(initial: HealthMviState) :
    MviReducer<HealthMviState, HealthMviEvent>(initial) {
    override fun reduce(
        oldState: HealthMviState,
        event: HealthMviEvent,
    ) {
        when (event) {
            is HealthMviEvent.ApplicationsFetchedMviEvent -> setState(
                oldState.copy(
                    loading = false,
                    content = HealthMviContent(
                        data = event.data,
                    ),
                    error = null,
                ),
            )

            HealthMviEvent.GetHealthMviEvent -> setState(
                oldState.copy(
                    loading = true,
                    content = null,
                    error = null,
                ),
            )
        }
    }
}
