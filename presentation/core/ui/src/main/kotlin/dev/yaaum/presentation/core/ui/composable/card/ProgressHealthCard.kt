package dev.yaaum.presentation.core.ui.composable.card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

@Composable
fun ProgressHealthCard(
    onClick: (() -> Unit)? = null,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(dev.yaaum.presentation.core.ui.theme.common.YaaumTheme.corners.medium))
            .background(dev.yaaum.presentation.core.ui.theme.common.YaaumTheme.colors.surface)
            .padding(dev.yaaum.presentation.core.ui.theme.common.YaaumTheme.spacing.small)
            .clickable {
                onClick?.invoke()
            },
    ) {
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ProgressHealthCard_Dark() {
    YaaumTheme(useDarkTheme = true) {
        ProgressHealthCard()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ProgressHealthCard_Light() {
    YaaumTheme(useDarkTheme = false) {
        ProgressHealthCard()
    }
}
