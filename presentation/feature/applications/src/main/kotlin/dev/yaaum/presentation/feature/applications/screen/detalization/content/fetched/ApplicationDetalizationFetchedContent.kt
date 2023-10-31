package dev.yaaum.presentation.feature.applications.screen.detalization.content.fetched

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

@Composable
fun ApplicationDetalizationFetchedContent() = Unit

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
