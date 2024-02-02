package dev.yaaum.presentation.feature.health.screen.health.mvi

import arrow.optics.copy
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
                        health = oldState.content?.health,
                        rate = oldState.content?.rate,
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

            is HealthMviEvent.GetApplicationsHealthMviEvent -> setState(
                oldState.copy(
                    loading = true,
                    content = null,
                    error = null,
                ),
            )

            is HealthMviEvent.ApplicationsHealthFetchedMviEvent ->
                setState(
                    oldState.copy(
                        loading = false,
                        content = HealthMviContent(
                            data = oldState.content?.data,
                            health = event.timeusage,
                            rate = oldState.content?.rate,
                        ),
                        error = null,
                    ),
                )

            HealthMviEvent.GetRate ->
                setState(
                    oldState.copy(
                        loading = true,
                        content = null,
                        error = null,
                    ),
                )

            is HealthMviEvent.OnRateFetched ->
                setState(
                    oldState.copy(
                        loading = false,
                        content = HealthMviContent(
                            data = oldState.content?.data,
                            health = oldState.content?.health,
                            rate = event.rate,
                        ),
                        error = null,
                    ),
                )
        }
    }
}
