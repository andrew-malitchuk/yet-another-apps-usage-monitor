package dev.yaaum.presentaion.feature.statistics.navigation.route

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.yaaum.presentaion.feature.statistics.screen.permissions.PermissionsScreen

/**
 * Route for PermissionsScreen
 */
class PermissionsRoute : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
//        val permissionsViewModel: PermissionsViewModel = koinViewModel()
//        val hostViewModel: HostViewModel = koinViewModel(
//            viewModelStoreOwner = LocalContext.current as ComponentActivity,
//        )

        PermissionsScreen(
            navigator = navigator,
        )
    }
}
