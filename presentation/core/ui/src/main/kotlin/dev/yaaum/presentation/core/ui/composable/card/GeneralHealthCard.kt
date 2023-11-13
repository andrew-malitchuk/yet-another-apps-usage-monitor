package dev.yaaum.presentation.core.ui.composable.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.composable.chart.donut.Chart
import dev.yaaum.presentation.core.ui.composable.item.YaaumBaseListContainer
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun GeneralHealthCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    YaaumBaseListContainer(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        onClick = {
            onClick?.invoke()
        },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        ) {
            Chart(
                modifier = Modifier
                    .height(128.dp),
            )

            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Cyan),
            )
            Column(
                modifier = Modifier
                    .weight(1f),
            ) {
            }
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
