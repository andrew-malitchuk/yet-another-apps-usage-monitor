package dev.yaaum.presentation.feature.applications.screen.composable.applications.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

@Suppress("EmptyFunctionBlock")
@Composable
fun ApplicationsContent() {
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationsContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        ApplicationsContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationsContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        ApplicationsContent()
    }
}
