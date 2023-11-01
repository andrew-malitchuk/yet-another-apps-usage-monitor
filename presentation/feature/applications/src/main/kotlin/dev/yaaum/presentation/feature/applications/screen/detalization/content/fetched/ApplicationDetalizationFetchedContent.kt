package dev.yaaum.presentation.feature.applications.screen.detalization.content.fetched

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun ApplicationDetalizationFetchedContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(YaaumTheme.colors.background),
    ) {
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationDetalizationFetchedContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        ApplicationDetalizationFetchedContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationDetalizationFetchedContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        ApplicationDetalizationFetchedContent()
    }
}
