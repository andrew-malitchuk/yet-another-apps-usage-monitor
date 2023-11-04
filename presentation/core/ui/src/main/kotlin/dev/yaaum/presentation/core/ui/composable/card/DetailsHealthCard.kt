package dev.yaaum.presentation.core.ui.composable.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.composable.button.ordinary.YaaumDefaultOrdinaryButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun DetailsHealthCard(
    modifier: Modifier =
        Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(YaaumTheme.corners.medium))
            .background(YaaumTheme.colors.surface)
            .padding(YaaumTheme.spacing.small),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        ) {
            YaaumDefaultOrdinaryButton(
                text = "foobar",
                onClick = { },
            )
            YaaumDefaultOrdinaryButton(
                text = "foobar",
                onClick = { },
            )
            YaaumDefaultOrdinaryButton(
                text = "foobar",
                onClick = { },
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(YaaumTheme.colors.onSurface),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DetailsHealthCard_Dark() {
    YaaumTheme(useDarkTheme = true) {
        DetailsHealthCard()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DetailsHealthCard_Light() {
    YaaumTheme(useDarkTheme = false) {
        DetailsHealthCard()
    }
}
