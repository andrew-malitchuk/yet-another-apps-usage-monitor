package dev.yaaum.presentation.feature.settings.screen.permission.content.fetched

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.header.SimpleHeader
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.settings.screen.permission.content.loading.PermissionLoadingContent
import dev.yaaum.presentation.feature.settings.screen.permission.item.fetched.PermissionFetchedListItem
import dev.yaaum.presentation.feature.settings.screen.permission.mvi.PermissionConfigure
import dev.yaaum.presentation.feature.settings.screen.permission.mvi.PermissionMviContent
import dev.yaaum.presentation.feature.settings.screen.permission.mvi.PermissionMviState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionFetchedContent(
    state: PermissionMviState,
    onInfoClick: (() -> Unit)? = null,
    onBackClick: (() -> Unit)? = null,
    onPermissionChangeState: ((PermissionChangeState) -> Unit)? = null,
) {
    val scrollState = rememberScrollState()

    val notificationPermissionState =
        rememberPermissionState(Manifest.permission.POST_NOTIFICATIONS)

    var isPostNotificationGranted by remember {
        mutableStateOf(false)
    }

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted ->
        isPostNotificationGranted = isGranted
    }

    LaunchedEffect(notificationPermissionState) {
        if (!notificationPermissionState.status.isGranted && notificationPermissionState.status.shouldShowRationale) {
            // Show rationale if needed
        } else {
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(YaaumTheme.colors.background),
    ) {
        SimpleHeader(
            icon = R.drawable.icon_info_bold_24,
            onActionClick = onInfoClick,
            onBackClick = onBackClick,
            title = UiText
                .StringResource(dev.yaaum.presentation.core.localisation.R.string.settings_permission_title)
                .asString(LocalContext.current),
            modifier = Modifier
                .padding(
                    start = YaaumTheme.spacing.medium,
                    end = YaaumTheme.spacing.medium,
                    top = YaaumTheme.spacing.medium,
                    bottom = YaaumTheme.spacing.small,
                ),
        )
        Box(
            modifier = Modifier
                .weight(1.0f),
        ) {
            when {
                (state.content?.data?.isValid() == false || state.content == null) ->
                    PermissionLoadingContent()

                (state.content.data?.isValid() == true) ->
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .background(YaaumTheme.colors.background)
                            .padding(horizontal = YaaumTheme.spacing.medium),
                        verticalArrangement = Arrangement
                            .spacedBy(YaaumTheme.spacing.small),
                    ) {
                        PermissionFetchedListItem(
                            permission = UiText
                                .StringResource(
                                    dev.yaaum.presentation.core.localisation
                                        .R.string.settings_permission_notification,
                                )
                                .asString(LocalContext.current),
                            icon = R.drawable.icon_notification_bold_24,
                            initValue = isPostNotificationGranted,
                            onPermissionClick = {
                                if (it) {
                                    notificationPermissionState.launchPermissionRequest()
                                }
                                isPostNotificationGranted = isPostNotificationGranted.not()
                            },
                        )
                        PermissionFetchedListItem(
                            permission = UiText
                                .StringResource(
                                    dev.yaaum.presentation.core.localisation
                                        .R.string.settings_permission_usage,
                                )
                                .asString(LocalContext.current),
                            icon = R.drawable.icon_chart_pie_slice_bold_24,
                            initValue = state.content.data.isAppUsagePermissionGranted ?: false,
                            onPermissionClick = {
                                onPermissionChangeState?.invoke(
                                    PermissionChangeState.OnAppUsageStateChanged(
                                        isGranted = it,
                                    ),
                                )
                            },
                        )
                    }
            }
        }
    }
}

sealed class PermissionChangeState {
    class OnNotificationStateChanged(val isGranted: Boolean) : PermissionChangeState()
    class OnAppUsageStateChanged(val isGranted: Boolean) : PermissionChangeState()
}

@Preview(showBackground = true)
@Composable
fun Preview_PermissionFetchedContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        PermissionFetchedContent(
            state = PermissionMviState.fetched(
                permissionMviContent = PermissionMviContent(
                    data = PermissionConfigure(
                        isNotificationPermissionGranted = true,
                        isAppUsagePermissionGranted = false,
                    ),
                ),
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_PermissionFetchedContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        PermissionFetchedContent(
            state = PermissionMviState.fetched(
                permissionMviContent = PermissionMviContent(
                    data = PermissionConfigure(
                        isNotificationPermissionGranted = true,
                        isAppUsagePermissionGranted = false,
                    ),
                ),
            ),
        )
    }
}
