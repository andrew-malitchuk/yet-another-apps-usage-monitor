package dev.yaaum.presentation.feature.settings.navigation.route

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.settings.screen.about.AboutScreen
import dev.yaaum.presentation.feature.settings.screen.about.AboutViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * Route for AboutScreen
 */
class AboutRoute : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val aboutViewModel: AboutViewModel = koinViewModel()
        val hostViewModel: HostViewModel = koinViewModel(
            viewModelStoreOwner = LocalContext.current as ComponentActivity,
        )

        AboutScreen(
            navigator = navigator,
            hostViewModel = hostViewModel,
            aboutViewModel = aboutViewModel,
        )
    }
}
