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
                HealthMviState.fetched(
                    content = HealthMviContent(
                        message = event.message,
                    ),
                ),
            )

            HealthMviEvent.GetHealthMviEvent -> setState(
                HealthMviState(
                    loading = true,
                    content = null,
                    error = null,
                ),
            )
        }
    }
}
