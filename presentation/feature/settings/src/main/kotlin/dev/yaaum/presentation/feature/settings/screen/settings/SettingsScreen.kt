package dev.yaaum.presentation.feature.settings.screen.settings

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.settings.screen.settings.content.fetched.SettingsFetchedContent

@Composable
fun SettingsScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    @Suppress("unused")
    settingsViewModel: SettingsViewModel,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen)
//    val permissionScreen = rememberScreen(RouteGraph.PermissionsScreen)
    val permissionScreen = rememberScreen(RouteGraph.PermissionScreen)
    val aboutScreen = rememberScreen(RouteGraph.AboutScreen)
//    val permissionScreen = rememberScreen(RouteGraph)

    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "mainScreen" to mainScreen,
            "permissionScreen" to permissionScreen,
            "aboutScreen" to aboutScreen,
            "isDarkMode" to isDarkMode,
        ),
    )
    YaaumTheme(isDarkMode) {
        SettingsFetchedContent(
            onPermissionClick = {
                navigator.push(permissionScreen)
            },
            onInfoClick = {
                navigator.push(aboutScreen)
            },
            onBackClick = {
                navigator.pop()
            },
        )
    }
}
