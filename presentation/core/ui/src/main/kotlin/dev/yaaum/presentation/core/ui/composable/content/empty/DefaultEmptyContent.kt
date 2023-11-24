package dev.yaaum.presentation.core.ui.composable.content.empty

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.composable.button.ordinary.YaaumOrdinaryButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun DefaultEmptyContent(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
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
                text = "Something went wrong!",
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
            YaaumOrdinaryButton(
                title = "Understandable",
                modifier = Modifier
                    .fillMaxWidth(),
                defaultBackgroundColor = YaaumTheme.colors.primary,
                pressedBackgroundColor = YaaumTheme.colors.secondary,
                onClick = {
                    onClick?.invoke()
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DefaultEmptyContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        DefaultEmptyContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DefaultEmptyContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        DefaultEmptyContent()
    }
}
