package dev.yaaum.presentation.core.ui.composable.content.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.composable.loader.YaaumLoader
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

/**
 * Display default loading screen
 */
@Composable
fun DefaultLoadingContent(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(YaaumTheme.colors.background),
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(YaaumTheme.spacing.medium),
        ) {
            // TODO: fix
            Text(
                text = "Something loading",
                style = YaaumTheme.typography.display,
                color = YaaumTheme.colors.onBackground,
            )
            Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
            // TODO: fix
            Text(
                text = "Please, wait",
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.onBackground,
            )
            Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
            YaaumLoader()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DefaultLoadingContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        DefaultLoadingContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DefaultLoadingContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        DefaultLoadingContent()
    }
}
