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
                    content = ApplicationDetalizationMviContent(
                        data = event.data,
                        packageName = event.packageName,
                        weekUsageStatics = oldState.content?.weekUsageStatics,
                    ),
                    error = null,
                ),
            )

            is ApplicationDetalizationMviEvent.GetApplicationDetalizationMviEvent -> setState(
                ApplicationDetalizationMviState.loading(),
            )

            is ApplicationDetalizationMviEvent.ApplicationsDetalizationFetchedMviEvent -> setState(
                ApplicationDetalizationMviState(
                    loading = false,
                    content = ApplicationDetalizationMviContent(
                        data = oldState.content?.data,
                        packageName = oldState.content?.packageName,
                        weekUsageStatics = event.weekUsageStatics.dayAndStatistic.toList(),
                    ),
                    error = null,
                ),
            )

            is ApplicationDetalizationMviEvent.GetApplicationUsageMviEvent -> setState(
                ApplicationDetalizationMviState.loading(),
            )
        }
    }
}
