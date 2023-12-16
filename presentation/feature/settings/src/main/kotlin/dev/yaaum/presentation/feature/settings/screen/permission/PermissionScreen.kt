package dev.yaaum.presentation.feature.settings.screen.permission

import android.app.PendingIntent
import android.content.Intent
import android.provider.Settings
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.platform.mvi.MviPartialState
import dev.yaaum.presentation.core.platform.permissions.ext.isAppUsageStatisticPermissionGranted
import dev.yaaum.presentation.core.ui.composable.content.error.DefaultErrorContent
import dev.yaaum.presentation.core.ui.composable.dialog.YaaumBottomSheetDialog
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.settings.dialog.PermissionDialogContent
import dev.yaaum.presentation.feature.settings.screen.permission.content.fetched.PermissionChangeState
import dev.yaaum.presentation.feature.settings.screen.permission.content.fetched.PermissionFetchedContent
import dev.yaaum.presentation.feature.settings.screen.permission.mvi.PermissionMvi
import dev.yaaum.presentation.feature.settings.screen.permission.mvi.PermissionMviEvent

// TODO: place it somewhere
@Suppress("TopLevelPropertyNaming")
const val requestCode = 1013

// TODO: recode
@Composable
@Suppress("LongMethod")
fun PermissionScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    permissionMvi: PermissionMvi,
) {
    val permissionsScreen = rememberScreen(RouteGraph.PermissionsScreen)

    val theme by hostViewModel.currentThemeUiModel.collectAsState()

    val state by permissionMvi.state.collectAsState()
    val effect by permissionMvi.effect.collectAsState(null)

    var showSheet by remember { mutableStateOf(false) }

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
                permissionMvi.sendEvent(
                    PermissionMviEvent.AppUsagePermissionStateChangedMviEvent(
                        true,
                    ),
                )
            } else {
                navigator.push(permissionsScreen)
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
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "permissionMvi" to permissionMvi,
            "theme" to theme,
            "state" to state,
            "effect" to effect,
            "showSheet" to showSheet,
        ),
    )

    if (showSheet) {
        YaaumBottomSheetDialog(
            onDismiss = {
                showSheet = false
            },
        ) {
            PermissionDialogContent(
                onDismiss = {
                    showSheet = false
                },
            )
        }
    }

    Log.d("foo", "${state.partialState}")

    YaaumTheme(theme = theme) {
        when (state.partialState) {
            MviPartialState.FETCHED ->
                PermissionFetchedContent(
                    state = state,
                    onBackClick = {
                        navigator.pop()
                    },
                    onInfoClick = {
                        showSheet = true
                    },
                    onPermissionChangeState = { permissionChangeState ->
                        when (permissionChangeState) {
                            is PermissionChangeState.OnAppUsageStateChanged ->
                                if (permissionChangeState.isGranted) {
                                    permissionMvi
                                        .sendEvent(
                                            PermissionMviEvent.AppUsagePermissionStateChangedMviEvent(
                                                isGranted = true,
                                            ),
                                        )
                                } else {
                                    launcher.launch(
                                        IntentSenderRequest.Builder(pendIntent).build(),
                                    )
                                }

                            is PermissionChangeState.OnNotificationStateChanged ->
                                permissionMvi
                                    .sendEvent(
                                        PermissionMviEvent.NotificationPermissionStateChangedMviEvent(
                                            isGranted = permissionChangeState.isGranted,
                                        ),
                                    )
                        }
                    },
                )

            else -> DefaultErrorContent(error = null)
        }
    }
}
