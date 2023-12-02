package dev.yaaum.presentation.feature.applications.screen.applications.mvi

import dev.yaaum.presentation.core.platform.mvi.MviReducer

class ApplicationsMviReducer(initial: ApplicationsMviState) :
    MviReducer<ApplicationsMviState, ApplicationsMviEvent>(initial) {
    override fun reduce(oldState: ApplicationsMviState, event: ApplicationsMviEvent) {
        when (event) {
            is ApplicationsMviEvent.GetApplicationsMviEvent -> setState(
                oldState.copy(
                    loading = true,
                    data = emptyList(),
                    error = null,
                ),
            )

            is ApplicationsMviEvent.ApplicationsFetchedMviEvent -> setState(
                oldState.copy(
                    loading = false,
                    data = event.data,
                    error = null,
                ),
            )
        }
    }
}
