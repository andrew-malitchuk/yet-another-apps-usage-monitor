package dev.yaaum.presentation.feature.applications.navigation.route

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.yaaum.presentation.feature.applications.screen.detalization.ApplicationDetalizationScreen
import dev.yaaum.presentation.feature.applications.screen.detalization.ApplicationDetalizationViewModel
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * Route for ApplicationDetalizationRoute
 */
class ApplicationDetalizationRoute : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val applicationDetalizationViewModel: ApplicationDetalizationViewModel = koinViewModel()
        val hostViewModel: HostViewModel = koinViewModel(
            viewModelStoreOwner = LocalContext.current as ComponentActivity,
        )

        ApplicationDetalizationScreen(
            navigator = navigator,
            hostViewModel = hostViewModel,
            applicationDetalizationViewModel = applicationDetalizationViewModel,
        )
    }
}