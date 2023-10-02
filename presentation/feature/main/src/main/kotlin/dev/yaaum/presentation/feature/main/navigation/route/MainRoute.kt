package dev.yaaum.presentation.feature.main.navigation.route

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import dev.yaaum.presentation.feature.main.screen.composable.main.MainScreen

/**
 * Route for MainScreen
 */
class MainRoute : Screen {
    @Composable
    override fun Content() {
        MainScreen()
    }
}
