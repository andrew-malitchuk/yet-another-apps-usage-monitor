package dev.yaaum.presentation.feature.main.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.main.screen.main.content.fetched.FetchedContent
import dev.yaaum.presentation.feature.main.screen.main.mvi.MainMvi

@Composable
fun MainScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    mainMvi: MainMvi,
) {
    @Suppress("UnusedPrivateProperty")
    val mainScreen = rememberScreen(RouteGraph.MainScreen)
    val theme by hostViewModel.currentThemeUiModel.collectAsState()

    val state by mainMvi.state.collectAsState()
    val effect by mainMvi.effect.collectAsState(null)

    val settingsScreen = rememberScreen(RouteGraph.SettingsScreen)
    val applicationsScreen = rememberScreen(RouteGraph.ApplicationsScreen)
    val permissionsScreen = rememberScreen(RouteGraph.PermissionsScreen)
    val healthScreen = rememberScreen(RouteGraph.HealthScreen)
    val applicationDetalizationScreen = rememberScreen(
        RouteGraph.ApplicationDetalizationScreen("foo"),
    )

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "theme" to theme,
            "state" to state,
            "effect" to effect,
        ),
    )
    YaaumTheme(theme = theme) {
//        when (state.partialState) {
//            MviPartialState.FETCHED ->
        FetchedContent(
            state = state,
            onSettingsClick = {
                navigator.push(settingsScreen)
            },
            onMoreClick = {
                navigator.push(applicationsScreen)
            },
            onHealthClick = {
                navigator.push(healthScreen)
            },
            onApplicationClick = {
                navigator.push(applicationDetalizationScreen)
            },
            onPermissionClick = {
                navigator.push(permissionsScreen)
            },
        )
//            MviPartialState.LOADING->
//                DefaultLoadingContent()
//
//            else -> Unit
//        }
    }
}
