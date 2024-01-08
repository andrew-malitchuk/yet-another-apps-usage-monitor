package dev.yaaum.presentaion.feature.statistics.screen.permissions

import android.app.PendingIntent
import android.content.Intent
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentaion.feature.statistics.screen.permissions.content.fetched.PermissionFetchedContent
import dev.yaaum.presentation.core.platform.permissions.ext.isAppUsageStatisticPermissionGranted
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

// TODO: place it somewhere
@Suppress("TopLevelPropertyNaming")
const val requestCode = 1012

// https://medium.com/@afrinsulthana/building-an-app-usage-tracker-in-android-fe79e959ab26
// https://proandroiddev.com/jetpack-compose-making-composable-lifecycle-aware-bde67437d2d0
@Composable
@Suppress("UnusedParameter")
fun PermissionsScreen(
    navigator: Navigator,
) {
//    val mainScreen = rememberScreen(RouteGraph.MainScreen)

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
            if (isGranted) {
                navigator.pop()
            }
        }
    }
    val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)
    val pendIntent =
        PendingIntent.getActivity(context, requestCode, intent, PendingIntent.FLAG_MUTABLE)
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult(),
        onResult = {},
    )

    Rebugger(
        trackMap = mapOf(),
    )
    YaaumTheme {
        PermissionFetchedContent(
            onPermissionClick = {
                launcher.launch(
                    IntentSenderRequest.Builder(pendIntent).build(),
                )
            },
        )
    }
}
