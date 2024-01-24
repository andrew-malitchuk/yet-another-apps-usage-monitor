package dev.yaaum.presentation.feature.settings.dialog.language

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.localisation.R
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.settings.dialog.language.item.LanguageListItem

@Composable
fun LanguageDialogContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(YaaumTheme.colors.background)
            .padding(YaaumTheme.spacing.medium),
    ) {
        Text(
            text = UiText
                .StringResource(R.string.settings_language_dialog_title)
                .asString(LocalContext.current),
            style = YaaumTheme.typography.display,
            color = YaaumTheme.colors.onBackground,
        )
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
        Text(
            text = UiText
                .StringResource(R.string.settings_language_dialog_description)
                .asString(LocalContext.current),
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onBackground,
        )
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement
                .spacedBy(YaaumTheme.spacing.small),
        ) {
            item {
                LanguageListItem(lang = "ukr")
            }
            item {
                LanguageListItem(lang = "eng")
            }
        }
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.extraLarge))
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_LanguageDialogContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        LanguageDialogContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_LanguageDialogContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        LanguageDialogContent()
    }
}
