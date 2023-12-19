package dev.yaaum.presentation.feature.main.screen.main.mvi

import dev.yaaum.domain.health.GetHealthStatusUseCase
import dev.yaaum.domain.timeusage.GetTopAppsWithHighestUsageUseCase
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.toUiModel
import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import dev.yaaum.presentation.core.ui.error.SwwUiError
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

@Suppress("Unused", "UnusedPrivateProperty")
class MainMvi(
    private val getTopAppsWithHighestUsageUseCase: GetTopAppsWithHighestUsageUseCase,
    private val getHealthStatusUseCase: GetHealthStatusUseCase,
) : BaseMvi<MainMviState, MainMviEvent, MainMviEffect>() {

    override val state: StateFlow<MainMviState>
        get() = reducer.state

    override val effect: SharedFlow<MainMviEffect?> = MutableSharedFlow()

    override val reducer = MainMviReducer(MainMviState.initial())

    private var searchJob: Job? = null

    override fun innerEventProcessing(event: MainMviEvent) {
        when (event) {
            MainMviEvent.GetMainMviEvent -> Unit
            MainMviEvent.GetTopAppsUsage -> getTopAppsUsage()
            is MainMviEvent.OnTopAppsUsageFetched -> Unit
            MainMviEvent.UpdateContent -> update()
            MainMviEvent.GetHealthStatus -> getHealthStatus()
        }
    }

    private fun update() {
        getTopAppsUsage()
    }

    private fun getTopAppsUsage() {
        launch(
            request = {
                getTopAppsWithHighestUsageUseCase(TOP_APPS_COUNT)
            },
            result = { result ->
                result?.fold({ error ->
                    reducer.setState(
                        MainMviState.error(
                            // TODO: fix me
                            SwwUiError(
                                UiText.DynamicString(error.message ?: ""),
                                error.throwable,
                            ),
                        ),
                    )
                }, { result ->
                    reducer.setState(
                        MainMviState.fetched(
                            content = MainMviContent(
                                topUsageApps = result.map { it.toUiModel() },
                            ),
                        ),
                    )
                })
            },
            loading = {
            },
        ) {
            reducer.setState(
                MainMviState.error(
                    // TODO: fix me
                    SwwUiError(
                        UiText.DynamicString(it.message ?: ""),
                        it,
                    ),
                ),
            )
        }
    }

    fun getHealthStatus() {
        launch(
            request = {
                // TODO: fix
                getHealthStatusUseCase(0L, 0L)
            },
            result = { result ->
                result?.fold({ error ->
                    reducer.setState(
                        MainMviState.error(
                            // TODO: fix me
                            SwwUiError(
                                UiText.DynamicString(error.message ?: ""),
                                error.throwable,
                            ),
                        ),
                    )
                }, { result ->
                    reducer.setState(
                        MainMviState.fetched(
                            content = MainMviContent(
                                topUsageApps = result.map { it.toUiModel() },
                            ),
                        ),
                    )
                })
            },
            loading = {
            },
        ) {
            reducer.setState(
                MainMviState.error(
                    // TODO: fix me
                    SwwUiError(
                        UiText.DynamicString(it.message ?: ""),
                        it,
                    ),
                ),
            )
        }
    }

    companion object {
        const val TOP_APPS_COUNT = 3
    }
}
