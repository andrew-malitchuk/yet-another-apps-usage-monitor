package dev.yaaum.presentation.feature.health.screen.health

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.health.screen.health.content.fetched.HealthFetchedContent
import dev.yaaum.presentation.feature.main.screen.HostViewModel

@Composable
@Suppress("UnusedParameter", "UnusedPrivateProperty")
fun HealthScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    @Suppress("unused")
    healthViewModel: HealthViewModel,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen)
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false
    val applicationsScreen = rememberScreen(RouteGraph.ApplicationsScreen)
    val applicationDetalizationScreen = rememberScreen(RouteGraph.ApplicationDetalizationScreen)

    val applicationList = healthViewModel.applicationStateFlow.collectAsStateWithLifecycle()
    healthViewModel.load()

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "healthViewModel" to healthViewModel,
            "mainScreen" to mainScreen,
            "applicationsScreen" to applicationsScreen,
            "isDarkMode" to isDarkMode,
        ),
    )
    YaaumTheme(isDarkMode) {
        HealthFetchedContent(
            applicationList = applicationList,
            onActionClick = {
                navigator.push(applicationsScreen)
            },
            onApplicationClick = {
                navigator.push(applicationDetalizationScreen)
            },
        )
    }
}
