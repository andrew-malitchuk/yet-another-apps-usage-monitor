package dev.yaaum.host.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.yaaum.host.screen.destinations.PostScreenDestination
import dev.yaaum.navigation.RouteGraph

@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class)
@Composable
fun HostScreen() {
//    val engine = rememberAnimatedNavHostEngine()
//    val navController = engine.rememberNavController()

//    val foodd = true
//    val startRoute  if (foo) RouteGraph.ONBOARDING_ROUTE else RouteGraph.MAIN_ROUTE
//    val startRoute = RouteGraph.ONBOARDING_ROUTE

    DestinationsNavHost(navGraph = NavGraphs.root)
}

//
@Destination(start = true)
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Login Screen")
        Button(onClick = {
            navigator.navigate(
//                ProfileScreenDestination( )
                RouteGraph.ONBOARDING_ROUTE,
            )
        }) {
            Text("Go to Profile Screen")
        }
    }
}

@Destination(
    route = "profile_screen",
)
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Profile Screen", textAlign = TextAlign.Center)
        Button(onClick = {
            navigator.navigate(PostScreenDestination())
        }) {
            Text("Go to Post Screen")
        }
    }
}

@Destination
@Composable
fun PostScreen(
    showOnlyPostsByUser: Boolean = false,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Post Screen, $showOnlyPostsByUser")
    }
}
//
