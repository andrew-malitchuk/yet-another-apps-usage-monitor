package dev.yaaum.presentation.feature.health.screen.health.mvi

import dev.yaaum.domain.applications.GetUserAppsUseCase
import dev.yaaum.domain.health.GetGeneralTimeUsageStatisticUseCase
import dev.yaaum.domain.health.GetRateUseCase
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.toUiModel
import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import dev.yaaum.presentation.core.ui.error.SwwUiError
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

@Suppress("Unused", "UnusedPrivateProperty")
class HealthMvi(
    private val getAllAppsUseCase: GetUserAppsUseCase,
    private val getGeneralTimeUsageStatisticUseCase: GetGeneralTimeUsageStatisticUseCase,
    private val getRateUseCase: GetRateUseCase,
) : BaseMvi<HealthMviState, HealthMviEvent, HealthMviEffect>() {

    override val state: StateFlow<HealthMviState>
        get() = reducer.state

    override val effect: SharedFlow<HealthMviEffect?> = MutableSharedFlow()

    override val reducer = HealthMviReducer(HealthMviState.initial())

    override fun innerEventProcessing(event: HealthMviEvent) {
        when (event) {
            is HealthMviEvent.ApplicationsFetchedMviEvent -> Unit
            HealthMviEvent.GetHealthMviEvent -> loadApplication()
            HealthMviEvent.GetApplicationsHealthMviEvent -> loadHealth()
            is HealthMviEvent.ApplicationsHealthFetchedMviEvent -> Unit
            HealthMviEvent.GetRate -> getRate()
            is HealthMviEvent.OnRateFetched -> Unit
        }
    }

    private fun loadApplication() {
        launch(
            request = {
                getAllAppsUseCase()
            },
            result = { result ->
                result?.fold({ error ->
                    reducer.setState(
                        HealthMviState.error(
                            // TODO: fix me
                            SwwUiError(
                                UiText.DynamicString(error.message ?: ""),
                                error.throwable,
                            ),
                        ),
                    )
                }, { data ->
                    reducer.setState(
                        HealthMviState.fetched(
                            content = HealthMviContent(
                                data = data.map { it.toUiModel() },
                                health = reducer.state.value.content?.health,
                            ),
                        ),
                    )
                })
            },
        )
    }

    private fun loadHealth() {
        launch(
            request = {
                getGeneralTimeUsageStatisticUseCase(
                    0L,
                    System.currentTimeMillis(),
                )
            },
            result = { result ->
                result?.fold({ error ->
                    reducer.setState(
                        HealthMviState.error(
                            // TODO: fix me
                            SwwUiError(
                                UiText.DynamicString(error.message ?: ""),
                                error.throwable,
                            ),
                        ),
                    )
                }, { data ->
                    reducer.setState(
                        HealthMviState.fetched(
                            content = HealthMviContent(
                                data = reducer.state.value.content?.data,
                                health = data.toUiModel(),
                            ),
                        ),
                    )
                })
            },
        )
    }

    private fun getRate() {
        launch(
            request = {
                getRateUseCase()
            },
            result = { result ->
                result?.fold(
                    { error ->
                        reducer.setState(
                            HealthMviState.error(
                                // TODO: fix me
                                SwwUiError(
                                    UiText.DynamicString(error.message ?: ""),
                                    error.throwable,
                                ),
                            ),
                        )
                    },
                    { result ->
                        reducer.setState(
                            HealthMviState.fetched(
                                content = (reducer.state.value.content ?: HealthMviContent())
                                    .copy(
                                        rate = result,
                                    ),
                            ),
                        )
                    },
                )
            },
            errorBlock = {
                reducer.setState(
                    HealthMviState.error(
                        // TODO: fix me
                        SwwUiError(
                            UiText.DynamicString(it.message ?: ""),
                            it,
                        ),
                    ),
                )
            },

        )
    }
}
