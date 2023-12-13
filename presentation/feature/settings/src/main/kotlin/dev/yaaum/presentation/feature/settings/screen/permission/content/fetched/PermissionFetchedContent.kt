package dev.yaaum.presentation.feature.settings.screen.permission.content.fetched

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.header.SimpleHeader
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.settings.screen.permission.item.PermissionListItem
import dev.yaaum.presentation.feature.settings.screen.permission.mvi.PermissionConfigure
import dev.yaaum.presentation.feature.settings.screen.permission.mvi.PermissionMviContent
import dev.yaaum.presentation.feature.settings.screen.permission.mvi.PermissionMviState

@Composable
fun PermissionFetchedContent(
    state: PermissionMviState,
    onInfoClick: (() -> Unit)? = null,
    onBackClick: (() -> Unit)? = null,
    onPermissionChangeState: ((PermissionChangeState) -> Unit)? = null,
) {
    val scrollState = rememberScrollState()

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
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(weight = 1f, fill = false)
                .background(YaaumTheme.colors.background)
                .padding(horizontal = YaaumTheme.spacing.medium),
            verticalArrangement = Arrangement
                .spacedBy(YaaumTheme.spacing.small),
        ) {
            PermissionListItem(
                permission = UiText
                    .StringResource(dev.yaaum.presentation.core.localisation.R.string.settings_permission_notification)
                    .asString(LocalContext.current),
                icon = R.drawable.icon_notification_bold_24,
                initValue = state.content?.data?.isNotificationPermissionGranted ?: false,
                onPermissionClick = {
                    onPermissionChangeState?.invoke(
                        PermissionChangeState.OnNotificationStateChanged(
                            isGranted = it,
                        ),
                    )
                },
            )
            PermissionListItem(
                permission = UiText
                    .StringResource(dev.yaaum.presentation.core.localisation.R.string.settings_permission_usage)
                    .asString(LocalContext.current),
                icon = R.drawable.icon_chart_pie_slice_bold_24,
                initValue = state.content?.data?.isAppUsagePermissionGranted ?: false,
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
