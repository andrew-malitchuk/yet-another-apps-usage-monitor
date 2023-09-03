package dev.yaaum.main.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.yaaum.main.screen.main.MainScreen

class MainRoute : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
//        val mainScreen = rememberScreen(SharedScreen.MainScreen)

        MainScreen(navigator)
    }
}
