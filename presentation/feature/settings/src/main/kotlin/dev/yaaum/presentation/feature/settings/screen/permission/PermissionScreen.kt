package dev.yaaum.presentation.feature.settings.screen.permission

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.platform.mvi.MviPartialState
import dev.yaaum.presentation.core.ui.composable.content.error.DefaultErrorContent
import dev.yaaum.presentation.core.ui.composable.content.loading.DefaultLoadingContent
import dev.yaaum.presentation.core.ui.composable.dialog.YaaumBottomSheetDialog
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.settings.dialog.PermissionDialogContent
import dev.yaaum.presentation.feature.settings.screen.permission.content.fetched.PermissionChangeState
import dev.yaaum.presentation.feature.settings.screen.permission.content.fetched.PermissionFetchedContent
import dev.yaaum.presentation.feature.settings.screen.permission.mvi.PermissionMvi
import dev.yaaum.presentation.feature.settings.screen.permission.mvi.PermissionMviEvent

@Composable
fun PermissionScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    permissionMvi: PermissionMvi,
) {
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false

    val state by permissionMvi.state.collectAsState()
    val effect by permissionMvi.effect.collectAsState(null)

    var showSheet by remember { mutableStateOf(false) }

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "permissionMvi" to permissionMvi,
            "isDarkMode" to isDarkMode,
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

    YaaumTheme(isDarkMode) {
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
                                permissionMvi
                                    .sendEvent(
                                        PermissionMviEvent.AppUsagePermissionStateChangedMviEvent(
                                            isGranted = permissionChangeState.isGranted,
                                        ),
                                    )

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

            MviPartialState.LOADING -> DefaultLoadingContent()

            else -> DefaultErrorContent(error = null)
        }
    }
}
