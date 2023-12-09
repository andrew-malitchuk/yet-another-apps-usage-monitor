package dev.yaaum.presentaion.feature.demo.screen.demo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentaion.feature.demo.screen.demo.content.DemoFetchedContent
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
    val theme by hostViewModel.currentThemeUiModel.collectAsState()
    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "mainScreen" to mainScreen,
            "theme" to theme,
        ),
    )
    @Suppress("OptionalWhenBraces")
    YaaumTheme(theme = theme) {
        DemoFetchedContent()
    }
}
