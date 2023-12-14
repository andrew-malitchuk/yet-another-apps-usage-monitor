package dev.yaaum.presentation.feature.settings.navigation.route

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.settings.screen.permission.PermissionScreen
import dev.yaaum.presentation.feature.settings.screen.permission.mvi.PermissionMvi
import org.koin.androidx.compose.koinViewModel

/**
 * Route for PermissionScreen
 */
class PermissionRoute : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val permissionMvi: PermissionMvi = koinViewModel()
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
        PermissionScreen(
            navigator = navigator,
            hostViewModel = hostViewModel,
            permissionMvi = permissionMvi,
        )
    }
}
