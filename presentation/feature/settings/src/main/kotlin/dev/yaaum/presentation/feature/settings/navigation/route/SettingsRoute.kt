package dev.yaaum.presentation.feature.settings.navigation.route

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.settings.screen.settings.SettingsScreen
import dev.yaaum.presentation.feature.settings.screen.settings.SettingsViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * Route for SettingsScreen
 */
class SettingsRoute : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val settingsViewModel: SettingsViewModel = koinViewModel()
        val hostViewModel: HostViewModel = koinViewModel(
            viewModelStoreOwner = LocalContext.current as ComponentActivity,
        )
        SettingsScreen(
            navigator = navigator,
            hostViewModel = hostViewModel,
            settingsViewModel = settingsViewModel,
        )
    }
}
