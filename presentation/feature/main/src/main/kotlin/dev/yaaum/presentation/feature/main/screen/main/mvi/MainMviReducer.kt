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
                    ),
                    error = null,
                ),
            )

            MainMviEvent.GetTopAppsUsage -> setState(
                oldState.copy(
                    loading = false,
                    content = MainMviContent(
                        topUsageApps = null,
                    ),
                    error = null,
                ),
            )

            is MainMviEvent.OnTopAppsUsageFetched -> setState(
                oldState.copy(
                    loading = false,
                    content = MainMviContent(
                        topUsageApps = event.apps,
                    ),
                    error = null,
                ),
            )

            MainMviEvent.UpdateContent -> setState(
                oldState.copy(
                    loading = false,
                    error = null,
                ),
            )
        }
    }
}
