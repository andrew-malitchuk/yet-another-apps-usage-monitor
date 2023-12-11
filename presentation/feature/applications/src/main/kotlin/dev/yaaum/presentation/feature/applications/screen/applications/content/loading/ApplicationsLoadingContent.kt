package dev.yaaum.presentation.feature.applications.screen.applications.content.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.applications.screen.applications.item.loading.ApplicationLoadingListItem

@Composable
fun ApplicationsLoadingContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(YaaumTheme.colors.background)
            .padding(horizontal = YaaumTheme.spacing.medium),
        verticalArrangement = Arrangement
            .spacedBy(YaaumTheme.spacing.small),
    ) {
        @Suppress("MagicNumber")
        repeat(5) {
            ApplicationLoadingListItem()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationsLoadingContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        ApplicationsLoadingContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationsLoadingContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        ApplicationsLoadingContent()
    }
}
