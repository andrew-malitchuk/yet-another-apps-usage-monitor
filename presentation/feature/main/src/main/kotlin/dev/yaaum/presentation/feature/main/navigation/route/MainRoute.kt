package dev.yaaum.presentation.feature.main.navigation.route

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.yaaum.presentation.feature.main.screen.composable.main.MainScreen

/**
 * Route for MainScreen
 *
 * @param from
 */
class MainRoute(private val from: String) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        MainScreen(navigator, from)
    }
}
