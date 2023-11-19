package dev.yaaum.presentation.feature.main.screen.main

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.main.screen.main.content.fetched.FetchedContent

@Composable
fun MainScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    mainViewModel: MainViewModel,
) {
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false
    val settingsScreen = rememberScreen(RouteGraph.SettingsScreen)
//    val applicationsScreen = rememberScreen(RouteGraph.ApplicationsScreen)
    val applicationsScreen = rememberScreen(RouteGraph.ApplicationsScreen)
    val healthScreen = rememberScreen(RouteGraph.HealthScreen)
    val applicationDetalizationScreen = rememberScreen(RouteGraph.ApplicationDetalizationScreen)

    val topAppsWithHighestUsage =
        mainViewModel.topAppsWithHighestUsageStateFlow.collectAsStateWithLifecycle()

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "isDarkMode" to isDarkMode,
            "topAppsWithHighestUsageStateFlow" to topAppsWithHighestUsage,
            "applicationDetalizationScreen" to applicationDetalizationScreen,
        ),
    )
    YaaumTheme(useDarkTheme = isDarkMode) {
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
