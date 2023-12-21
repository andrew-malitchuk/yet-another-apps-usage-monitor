package dev.yaaum.presentation.core.ui.composable.card

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.common.core.ext.asHours
import dev.yaaum.presentation.core.models.GeneralTimeUsageStatisticUiModel
import dev.yaaum.presentation.core.ui.composable.chart.CircleChartModel
import dev.yaaum.presentation.core.ui.composable.chart.donut.YaaumChartDonut
import dev.yaaum.presentation.core.ui.composable.ext.placeholder
import dev.yaaum.presentation.core.ui.composable.item.YaaumBaseListContainer
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

/**
 * General information about "user's health"
 */
@Suppress("LongMethod")
@Composable
fun GeneralHealthCard(
    timeUsage: GeneralTimeUsageStatisticUiModel?,
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
        when {
            (timeUsage == null) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .placeholder(
                            backgroundColor = YaaumTheme.colors.surface,
                            isLoading = true,
                            shape = RoundedCornerShape(YaaumTheme.corners.medium),
                        )
                        .padding(YaaumTheme.spacing.medium),
                ) {
                    @Suppress("MagicNumber")
                    Box(modifier = Modifier.height(128.dp))
                }

            else ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(YaaumTheme.spacing.medium),
                ) {
                    @Suppress("MagicNumber")
                    YaaumChartDonut(
                        entries = listOf(
                            CircleChartModel(Color.Red, timeUsage.totalUsersAppsUsagePercent),
                            CircleChartModel(Color.Green, timeUsage.totalChosenAppsUsagePercent),
                            CircleChartModel(Color.Yellow, timeUsage.totalAppsUsagePercent),
                        ),
                        modifier = Modifier
                            .height(YaaumTheme.icons.large),
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
                            Canvas(
                                modifier = Modifier
                                    .size(YaaumTheme.icons.small)
                                    .clip(CircleShape)
                                    .background(Color.Red),
                            ) {}
                            Spacer(
                                modifier = Modifier
                                    .width(YaaumTheme.spacing.small),
                            )
                            Text(
                                text = timeUsage.totalAppsUsage.asHours(),
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
                            Canvas(
                                modifier = Modifier
                                    .size(YaaumTheme.icons.small)
                                    .clip(CircleShape)
                                    .background(Color.Green),
                            ) {}
                            Spacer(
                                modifier = Modifier
                                    .width(YaaumTheme.spacing.small),
                            )
                            Text(
                                text = timeUsage.totalChosenAppsUsage.asHours(),
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
                            Canvas(
                                modifier = Modifier
                                    .size(YaaumTheme.icons.small)
                                    .clip(CircleShape)
                                    .background(Color.Yellow),
                            ) {}
                            Spacer(
                                modifier = Modifier
                                    .width(YaaumTheme.spacing.small),
                            )
                            Text(
                                text = timeUsage.totalUsersAppsUsage.asHours(),
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
}

@Preview(showBackground = true)
@Composable
fun Preview_GeneralHealthCard_Loading_Dark() {
    YaaumTheme(useDarkTheme = true) {
        GeneralHealthCard(timeUsage = null)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_GeneralHealthCard_Loading_Light() {
    YaaumTheme(useDarkTheme = false) {
        GeneralHealthCard(timeUsage = null)
    }
}

@Preview(showBackground = true)
@Composable
@Suppress("MagicNumber")
fun Preview_GeneralHealthCard_Fetched_Dark() {
    YaaumTheme(useDarkTheme = true) {
        GeneralHealthCard(timeUsage = GeneralTimeUsageStatisticUiModel(100, 100, 100))
    }
}

@Preview(showBackground = true)
@Composable
@Suppress("MagicNumber")
fun Preview_GeneralHealthCard_Fetched_Light() {
    YaaumTheme(useDarkTheme = false) {
        GeneralHealthCard(timeUsage = GeneralTimeUsageStatisticUiModel(100, 100, 100))
    }
}
