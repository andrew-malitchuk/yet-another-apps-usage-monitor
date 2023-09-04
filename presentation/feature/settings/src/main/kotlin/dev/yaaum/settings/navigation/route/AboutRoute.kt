package dev.yaaum.settings.navigation.route

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.yaaum.settings.screen.composable.about.AboutScreen

/**
 * Route for AboutScreen
 */
class AboutRoute : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
//        val mainScreen = rememberScreen(SharedScreen.MainScreen)

        AboutScreen(navigator)
    }
}
