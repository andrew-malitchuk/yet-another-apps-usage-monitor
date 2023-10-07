package dev.yaaum.presentation.core.ui.composable.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun GeneralHealthCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(YaaumTheme.corners.medium))
            .background(YaaumTheme.colors.surface)
            .padding(YaaumTheme.spacing.small),
    ) {
        Box(
            modifier = Modifier
                .width(128.dp)
                .height(128.dp)
                .background(YaaumTheme.colors.background),
        )
        Spacer(
            modifier = Modifier
                .width(YaaumTheme.spacing.medium),
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_GeneralHealthCard_Dark() {
    YaaumTheme(useDarkTheme = true) {
        GeneralHealthCard()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_GeneralHealthCard_Light() {
    YaaumTheme(useDarkTheme = false) {
        GeneralHealthCard()
    }
}
