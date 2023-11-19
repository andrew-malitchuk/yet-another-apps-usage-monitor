package dev.yaaum.presentation.feature.main.screen.main.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun EmptyContent() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .verticalScroll(scrollState)
            .background(YaaumTheme.colors.background),
    ) {
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_EmptyContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        EmptyContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_EmptyContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        EmptyContent()
    }
}
