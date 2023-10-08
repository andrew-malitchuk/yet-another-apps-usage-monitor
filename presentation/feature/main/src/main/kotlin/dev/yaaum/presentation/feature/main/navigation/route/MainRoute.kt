package dev.yaaum.presentation.feature.main.navigation.route

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import dev.yaaum.presentation.feature.main.screen.composable.HostViewModel
import dev.yaaum.presentation.feature.main.screen.composable.main.MainScreen
import org.koin.androidx.compose.koinViewModel

/**
 * Route for MainScreen
 */
class MainRoute : Screen {
    @Composable
    override fun Content() {
        val hostViewModel: HostViewModel = koinViewModel(
            viewModelStoreOwner = LocalContext.current as ComponentActivity,
        )

        MainScreen(
            hostViewModel = hostViewModel,
        )
    }
}
