package dev.yaaum.presentaion.feature.demo.screen.demo

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentaion.feature.demo.screen.demo.content.DemoFetchedContent
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel

@Composable
@Suppress("UnusedParameter", "UnusedPrivateProperty")
fun DemoScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen)
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false
    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "mainScreen" to mainScreen,
            "isDarkMode" to isDarkMode,
        ),
    )
    @Suppress("OptionalWhenBraces")
    YaaumTheme(isDarkMode) {
        DemoFetchedContent()
    }
}
