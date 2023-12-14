package dev.yaaum.presentation.feature.applications.navigation.route

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.yaaum.presentation.feature.applications.screen.applications.ApplicationsScreen
import dev.yaaum.presentation.feature.applications.screen.applications.mvi.ApplicationsMvi
import dev.yaaum.presentation.feature.applications.screen.applications.mvi.ApplicationsMviEvent
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * Route for ApplicationsRoute
 */
class ApplicationsRoute : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val applicationsMvi: ApplicationsMvi = koinViewModel()
        val hostViewModel: HostViewModel = koinViewModel(
            viewModelStoreOwner = LocalContext.current as ComponentActivity,
        )
        LifecycleEffect(
            onStarted = {
                hostViewModel.updateTheme()
                applicationsMvi.sendEvent(ApplicationsMviEvent.GetApplicationsMviEvent)
            },
            onDisposed = {
            },
        )

        ApplicationsScreen(
            navigator = navigator,
            hostViewModel = hostViewModel,
            applicationsMvi = applicationsMvi,
        )
    }
}
