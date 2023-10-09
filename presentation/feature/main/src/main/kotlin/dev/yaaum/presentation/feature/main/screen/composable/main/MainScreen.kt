package dev.yaaum.presentation.feature.main.screen.composable.main

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.composable.HostViewModel
import dev.yaaum.presentation.feature.main.screen.composable.main.content.fetched.FetchedContent

@Composable
fun MainScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
) {
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false
    val settingsScreen = rememberScreen(RouteGraph.SettingsScreen)

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "isDarkMode" to isDarkMode,
        ),
    )
    YaaumTheme(useDarkTheme = isDarkMode) {
//        ErrorContent(
//            "Lorem ipsum",
//            "Dolor sit amen"
//        )
        FetchedContent(
            onSettingsClick = {
                navigator.push(settingsScreen)
            },
        )
    }
}
