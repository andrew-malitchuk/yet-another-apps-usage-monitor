package dev.yaaum.presentation.core.ui.composable.button.various

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

@Composable
fun ThemeButton() = Unit

@Preview(showBackground = true)
@Composable
fun Preview_ThemeButton_Dark() {
    YaaumTheme(useDarkTheme = true) {
        ThemeButton()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ThemeButton_Light() {
    YaaumTheme(useDarkTheme = false) {
        ThemeButton()
    }
}
