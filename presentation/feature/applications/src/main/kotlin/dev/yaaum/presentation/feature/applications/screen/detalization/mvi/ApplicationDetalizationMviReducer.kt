package dev.yaaum.presentation.feature.applications.screen.detalization.mvi

import dev.yaaum.presentation.core.platform.mvi.MviReducer

class ApplicationDetalizationMviReducer(initial: ApplicationDetalizationMviState) :
    MviReducer<ApplicationDetalizationMviState, ApplicationDetalizationMviEvent>(initial) {
    override fun reduce(
        oldState: ApplicationDetalizationMviState,
        event: ApplicationDetalizationMviEvent,
    ) {
        when (event) {
            is ApplicationDetalizationMviEvent.ApplicationsFetchedMviEvent -> setState(
                ApplicationDetalizationMviState(
                    loading = false,
                    data = event.data,
                    error = null,
                ),
            )

            ApplicationDetalizationMviEvent.GetApplicationDetalizationMviEvent -> setState(
                ApplicationDetalizationMviState.loading(),
            )
        }
    }
}
