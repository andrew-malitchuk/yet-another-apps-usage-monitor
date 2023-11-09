package dev.yaaum.presentation.feature.settings.screen.settings.content.fetched

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.header.SimpleHeader
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.settings.screen.settings.content.fetched.item.SettingsListItem
import dev.yaaum.presentation.feature.settings.screen.settings.content.fetched.item.ThemeListItem

@Composable
fun SettingsFetchedContent(
    onInfoClick: (() -> Unit)? = null,
    onPermissionClick: (() -> Unit)? = null,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(YaaumTheme.colors.background),
    ) {
        SimpleHeader(
            icon = ImageVector.vectorResource(R.drawable.icon_info_bold_24),
            onClick = onInfoClick,
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
            SettingsListItem(
                title = "Language",
                icon = R.drawable.icon_translate_bold_24,
                onClick = {
                },
            )
            SettingsListItem(
                title = "Permission",
                icon = R.drawable.icon_lock_bold_24,
                onClick = {
                    onPermissionClick?.invoke()
                },
            )
            ThemeListItem()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_SettingsFetchedContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        SettingsFetchedContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_SettingsFetchedContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        SettingsFetchedContent()
    }
}
