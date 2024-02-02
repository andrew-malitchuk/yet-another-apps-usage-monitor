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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.ThemeUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.various.SelectedTheme
import dev.yaaum.presentation.core.ui.composable.header.SimpleHeader
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.settings.screen.settings.item.SettingsListItem
import dev.yaaum.presentation.feature.settings.screen.settings.item.ThemeListItem

@Composable
fun SettingsFetchedContent(
    theme: ThemeUiModel? = null,
    onInfoClick: (() -> Unit)? = null,
    onBackClick: (() -> Unit)? = null,
    onPermissionClick: (() -> Unit)? = null,
    onLangClick: (() -> Unit)? = null,
    onThemeSelected: ((SelectedTheme) -> Unit)? = null,
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
                .StringResource(dev.yaaum.presentation.core.localisation.R.string.settings_title)
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
            SettingsListItem(
                title = UiText
                    .StringResource(dev.yaaum.presentation.core.localisation.R.string.settings_language)
                    .asString(LocalContext.current),
                icon = R.drawable.icon_translate_bold_24,
                onClick = {
                    onLangClick?.invoke()
                },
            )
            SettingsListItem(
                title = UiText
                    .StringResource(dev.yaaum.presentation.core.localisation.R.string.settings_permission)
                    .asString(LocalContext.current),
                icon = R.drawable.icon_lock_bold_24,
                onClick = {
                    onPermissionClick?.invoke()
                },
            )
            ThemeListItem(
                theme = theme,
                onThemeSelected = onThemeSelected,
            )
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
