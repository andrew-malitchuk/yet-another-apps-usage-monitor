package dev.yaaum.presentation.feature.applications.screen.applications

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.platform.mvi.MviPartialState
import dev.yaaum.presentation.core.ui.composable.content.empty.DefaultEmptyContent
import dev.yaaum.presentation.core.ui.composable.content.error.DefaultErrorContent
import dev.yaaum.presentation.core.ui.composable.content.loading.DefaultLoadingContent
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.applications.screen.applications.content.fetched.ApplicationsFetchedContent
import dev.yaaum.presentation.feature.applications.screen.applications.mvi.ApplicationsMvi
import dev.yaaum.presentation.feature.main.screen.HostViewModel

@Composable
@Suppress("UnusedParameter", "UnusedPrivateProperty")
fun ApplicationsScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    applicationsMvi: ApplicationsMvi,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen)
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false

    val state by applicationsMvi.state.collectAsState()
    val effect by applicationsMvi.effect.collectAsState(null)

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "applicationsMvi" to applicationsMvi,
            "mainScreen" to mainScreen,
            "isDarkMode" to isDarkMode,
            "state" to state,
            "effect" to effect,
        ),
    )

    YaaumTheme(isDarkMode) {
        when (state.partialState) {
            MviPartialState.FETCHED -> ApplicationsFetchedContent(
                state = state,
            )

            MviPartialState.LOADING -> DefaultLoadingContent()
            MviPartialState.ERROR -> DefaultErrorContent(error = state.error)
            MviPartialState.EMPTY -> DefaultEmptyContent()
        }

        /*ApplicationsFetchedContent(
            applicationList = applicationList,
            onBackClick = {
                applicationsViewModel.reset()
                navigator.pop()
            },
            onTextChange = applicationsViewModel::updateFilterQuery,
            onSideChange = applicationsViewModel::updateFilterSort,
            onApplicationClick = applicationsViewModel::changeApplicationStatus,
        )*/
    }
}
