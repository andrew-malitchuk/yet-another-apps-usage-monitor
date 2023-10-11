package dev.yaaum.presentation.feature.applications.screen.composable.applications

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.applications.screen.ApplicationsViewModel
import dev.yaaum.presentation.feature.applications.screen.composable.applications.content.ApplicationsContent
import dev.yaaum.presentation.feature.main.screen.HostViewModel

@Composable
@Suppress("UnusedParameter", "UnusedPrivateProperty")
fun ApplicationsScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    @Suppress("unused")
    applicationsViewModel: ApplicationsViewModel,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen)
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false

    val applicationList = applicationsViewModel.applicationStateFlow.collectAsStateWithLifecycle()

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "applicationsViewModel" to applicationsViewModel,
            "mainScreen" to mainScreen,
            "isDarkMode" to isDarkMode,
        ),
    )
    YaaumTheme(isDarkMode) {
        ApplicationsContent(
            applicationList,
        )
    }
}
