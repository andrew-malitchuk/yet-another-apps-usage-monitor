package dev.yaaum.presentation.feature.health.navigation.route

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.yaaum.presentation.feature.health.screen.health.HealthScreen
import dev.yaaum.presentation.feature.health.screen.health.HealthViewModel
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * Route for HealthScreen
 */
class HealthRoute : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val healthViewModel: HealthViewModel = koinViewModel()
        val hostViewModel: HostViewModel = koinViewModel(
            viewModelStoreOwner = LocalContext.current as ComponentActivity,
        )

        HealthScreen(
            navigator = navigator,
            hostViewModel = hostViewModel,
            healthViewModel = healthViewModel,
        )
    }
}
