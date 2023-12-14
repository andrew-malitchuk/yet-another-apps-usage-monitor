package dev.yaaum.presentaion.feature.demo.navigation.route

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.yaaum.presentaion.feature.demo.screen.demo.DemoScreen
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * Route for DemoScreen
 */
class DemoRoute : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val hostViewModel: HostViewModel = koinViewModel(
            viewModelStoreOwner = LocalContext.current as ComponentActivity,
        )
        LifecycleEffect(
            onStarted = {
                hostViewModel.updateTheme()
            },
            onDisposed = {
            },
        )
        DemoScreen(
            navigator = navigator,
            hostViewModel = hostViewModel,
        )
    }
}
