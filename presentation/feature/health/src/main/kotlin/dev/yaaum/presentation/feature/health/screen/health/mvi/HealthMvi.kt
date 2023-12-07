package dev.yaaum.presentation.feature.health.screen.health.mvi

import dev.yaaum.domain.applications.GetUserAppsUseCase
import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

@Suppress("Unused", "UnusedPrivateProperty")
class HealthMvi(
    private val getAllAppsUseCase: GetUserAppsUseCase,
) : BaseMvi<HealthMviState, HealthMviEvent, HealthMviEffect>() {

    override val state: StateFlow<HealthMviState>
        get() = reducer.state

    override val effect: SharedFlow<HealthMviEffect?> = MutableSharedFlow()

    override val reducer = HealthMviReducer(HealthMviState.initial())

    override fun innerEventProcessing(event: HealthMviEvent) {
        when (event) {
            is HealthMviEvent.ApplicationsFetchedMviEvent -> Unit
            HealthMviEvent.GetHealthMviEvent -> loadApplication()
        }
    }

    private fun loadApplication() {
//        sendEvent(HealthMviEvent.ApplicationsFetchedMviEvent(message = "foobar"))
        reducer.setState(
            HealthMviState.fetched(
                content = HealthMviContent(
                    message = "foobar",
                ),
            ),
        )

        /*launch(
            request = {
                getAllAppsUseCase()
            },
            result = { result ->
                result?.fold({ error ->
                    areApplicationsFailedStateFlow.setValue(error)
                }, { result ->
                    applicationStateFlow.setValue(result.map { it.toUiModel() })
                })
            },
            loading = {
                areApplicationsLoadingStateFlow.setValue(it)
            },
            errorBlock = {
                areApplicationsFailedStateFlow.setValue(it)
            },
        )*/
    }

    init {
        sendEvent(HealthMviEvent.GetHealthMviEvent)
    }
}
