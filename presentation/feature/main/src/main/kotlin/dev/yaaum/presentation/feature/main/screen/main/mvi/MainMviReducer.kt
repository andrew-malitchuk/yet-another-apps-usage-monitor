package dev.yaaum.presentation.feature.main.screen.main.mvi

import dev.yaaum.presentation.core.platform.mvi.MviReducer

class MainMviReducer(initial: MainMviState) :
    MviReducer<MainMviState, MainMviEvent>(initial) {
    override fun reduce(oldState: MainMviState, event: MainMviEvent) {
        when (event) {
            is MainMviEvent.GetMainMviEvent -> setState(
                oldState.copy(
                    loading = true,
                    content = MainMviContent(
                        topUsageApps = null,
                        healthStatus = null,
                    ),
                    error = null,
                ),
            )

            MainMviEvent.GetTopAppsUsage -> {
                val previous = oldState.content ?: MainMviContent()
                setState(
                    oldState.copy(
                        loading = false,
                        content = previous.copy(
                            topUsageApps = null,
                        ),
                        error = null,
                    ),
                )
            }

            is MainMviEvent.OnTopAppsUsageFetched -> {
                val previous = oldState.content ?: MainMviContent()
                setState(
                    oldState.copy(
                        loading = false,
                        content = previous.copy(
                            topUsageApps = event.apps,
                        ),
                        error = null,
                    ),
                )
            }

            MainMviEvent.UpdateContent -> setState(
                oldState.copy(
                    loading = false,
                    error = null,
                ),
            )

            MainMviEvent.GetHealthStatus -> {
                val previous = oldState.content ?: MainMviContent()
                setState(
                    oldState.copy(
                        loading = false,
                        content = previous.copy(
                            healthStatus = null,
                        ),
                        error = null,
                    ),
                )
            }

            is MainMviEvent.OnHealthStatusFetched -> {
                val previous = oldState.content ?: MainMviContent()
                setState(
                    oldState.copy(
                        loading = false,
                        content = previous.copy(
                            healthStatus = event.status,
                        ),
                        error = null,
                    ),
                )
            }

            MainMviEvent.GetGeneralTimeUsage -> {
                val previous = oldState.content ?: MainMviContent()
                setState(
                    oldState.copy(
                        loading = false,
                        content = previous.copy(
                            timeUsage = null,
                        ),
                        error = null,
                    ),
                )
            }

            is MainMviEvent.OnGeneralTimeUsageFetched -> {
                val previous = oldState.content ?: MainMviContent()
                setState(
                    oldState.copy(
                        loading = false,
                        content = previous.copy(
                            timeUsage = event.timeUsage,
                        ),
                        error = null,
                    ),
                )
            }
        }
    }
}
