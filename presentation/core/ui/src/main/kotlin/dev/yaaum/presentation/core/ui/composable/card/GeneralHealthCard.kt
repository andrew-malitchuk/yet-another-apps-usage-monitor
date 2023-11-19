package dev.yaaum.presentation.core.ui.composable.card

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.composable.chart.CircleChartModel
import dev.yaaum.presentation.core.ui.composable.chart.donut.YaaumChartDonut
import dev.yaaum.presentation.core.ui.composable.item.YaaumBaseListContainer
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

/**
 * General information about "user's health"
 */
@Suppress("LongMethod")
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
                .wrapContentHeight()
                .padding(YaaumTheme.spacing.medium),
        ) {
            @Suppress("MagicNumber")
            YaaumChartDonut(
                entries = listOf(
                    CircleChartModel(Color.Red, 0.5f),
                    CircleChartModel(Color.Green, 0.3f),
                    CircleChartModel(Color.Blue, 0.2f),
                ),
                modifier = Modifier
                    .height(128.dp),
            )
            Spacer(
                modifier = Modifier
                    .width(YaaumTheme.spacing.medium),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                ) {
                    // TODO: fix
                    Canvas(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(Color.Red),
                    ) {}
                    Spacer(
                        modifier = Modifier
                            .width(YaaumTheme.spacing.small),
                    )
                    Text(
                        text = Faker().quote.fortuneCookie(),
                        style = YaaumTheme.typography.title,
                        color = YaaumTheme.colors.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = YaaumTheme.spacing.small),
                ) {
                    // TODO: fix
                    Canvas(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(Color.Green),
                    ) {}
                    Spacer(
                        modifier = Modifier
                            .width(YaaumTheme.spacing.small),
                    )
                    Text(
                        text = Faker().quote.fortuneCookie(),
                        style = YaaumTheme.typography.title,
                        color = YaaumTheme.colors.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                ) {
                    // TODO: fix
                    Canvas(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(Color.Blue),
                    ) {}
                    Spacer(
                        modifier = Modifier
                            .width(YaaumTheme.spacing.small),
                    )
                    Text(
                        text = Faker().quote.fortuneCookie(),
                        style = YaaumTheme.typography.title,
                        color = YaaumTheme.colors.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
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
