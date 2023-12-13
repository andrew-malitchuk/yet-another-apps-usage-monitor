package dev.yaaum.presentation.feature.main.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.main.screen.main.content.fetched.FetchedContent
import io.getstream.log.StreamLog
import io.getstream.log.streamLog

@Composable
fun MainScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    mainViewModel: MainViewModel,
) {
    val theme by hostViewModel.currentThemeUiModel.collectAsState()
    val settingsScreen = rememberScreen(RouteGraph.SettingsScreen)
    val applicationsScreen = rememberScreen(RouteGraph.ApplicationsScreen)
    val healthScreen = rememberScreen(RouteGraph.HealthScreen)
    val applicationDetalizationScreen = rememberScreen(
        RouteGraph.ApplicationDetalizationScreen("foo"),
    )

    val topAppsWithHighestUsage =
        mainViewModel.topAppsWithHighestUsageStateFlow.collectAsStateWithLifecycle()

    StreamLog.streamLog {
        "foobarfoobar"
    }

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "theme" to theme,
            "topAppsWithHighestUsageStateFlow" to topAppsWithHighestUsage,
            "applicationDetalizationScreen" to applicationDetalizationScreen,
        ),
    )
    YaaumTheme(theme = theme) {
//        ErrorContent(
//            "Lorem ipsum",
//            "Dolor sit amen"
//        )
        FetchedContent(
            topAppsWithHighestUsage = topAppsWithHighestUsage,
            onSettingsClick = {
                navigator.push(settingsScreen)
            },
            onMoreClick = {
                navigator.push(applicationsScreen)
            },
            onHealthClick = {
                navigator.push(healthScreen)
            },
            onAppClick = {
                navigator.push(applicationDetalizationScreen)
            },
        )
    }
}
