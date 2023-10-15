package dev.yaaum.presentaion.feature.statistics.screen.composable.permissions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.platform.permissions.ext.isAppUsageStatisticPermissionGranted
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import logcat.logcat

// https://medium.com/@afrinsulthana/building-an-app-usage-tracker-in-android-fe79e959ab26
// https://proandroiddev.com/jetpack-compose-making-composable-lifecycle-aware-bde67437d2d0
@Composable
fun PermissionsScreen(
    navigator: Navigator,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen)

    var lifecycleEvent by remember { mutableStateOf(Lifecycle.Event.ON_ANY) }
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val lifecycleObserver = LifecycleEventObserver { _, event ->
            lifecycleEvent = event
        }

        lifecycleOwner.lifecycle.addObserver(lifecycleObserver)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(lifecycleObserver)
        }
    }
    val context = LocalContext.current

    LaunchedEffect(lifecycleEvent) {
        if (lifecycleEvent == Lifecycle.Event.ON_RESUME) {
            val isGranted = context.isAppUsageStatisticPermissionGranted()
            logcat("isGranted") {
                isGranted.toString()
            }
        }
    }

    Rebugger(
        trackMap = mapOf(),
    )
    YaaumTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Text(text = "Permissions")
            Button(onClick = {
                navigator.push(mainScreen)
            }) {
                Text(text = "Main")
            }
        }
    }
}
