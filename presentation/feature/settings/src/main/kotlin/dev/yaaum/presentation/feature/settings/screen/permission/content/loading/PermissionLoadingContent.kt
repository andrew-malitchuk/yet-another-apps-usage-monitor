package dev.yaaum.presentation.feature.settings.screen.permission.content.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.settings.screen.permission.item.loading.PermissionLoadingListItem

@Composable
fun PermissionLoadingContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .background(YaaumTheme.colors.background)
            .padding(horizontal = YaaumTheme.spacing.medium),
        verticalArrangement = Arrangement
            .spacedBy(YaaumTheme.spacing.small),
    ) {
        PermissionLoadingListItem(
            icon = dev.yaaum.presentation.core.ui.R.drawable.icon_notification_bold_24,
        )
        PermissionLoadingListItem(
            icon = dev.yaaum.presentation.core.ui.R.drawable.icon_notification_bold_24,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_PermissionLoadingContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        PermissionLoadingContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_PermissionLoadingContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        PermissionLoadingContent()
    }
}
