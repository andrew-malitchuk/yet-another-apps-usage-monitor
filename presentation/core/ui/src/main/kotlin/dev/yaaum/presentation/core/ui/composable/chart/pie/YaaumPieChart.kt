package dev.yaaum.presentation.core.ui.composable.chart.pie

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.composable.chart.CircleChartModel
import dev.yaaum.presentation.core.ui.composable.chart.calculateStartAngles
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

/**
 * Pie chart
 *
 * @param modifier
 * @param entries content to display
 */
@Suppress("MagicNumber")
@Composable
fun YaaumPieChart(
    entries: List<CircleChartModel>,
    modifier: Modifier = Modifier,
) {
    androidx.compose.foundation.Canvas(
        modifier = modifier
            .aspectRatio(1f),
        onDraw = {
            val startAngles = calculateStartAngles(entries)
            entries.forEachIndexed { index, entry ->
                drawArc(
                    color = entry.color,
                    startAngle = startAngles[index],
                    sweepAngle = entry.percentage * 360f,
                    useCenter = true,
                    topLeft = Offset.Zero,
                    size = this.size,
                )
            }
        },
    )
}

@Suppress("MagicNumber")
@Preview(showBackground = true)
@Composable
fun Preview_YaaumPieChart_Dark() {
    YaaumTheme(useDarkTheme = true) {
        YaaumPieChart(
            entries = listOf(
                CircleChartModel(Color.Red, 0.5f),
                CircleChartModel(Color.Green, 0.3f),
                CircleChartModel(Color.Blue, 0.2f),
            ),
            modifier = Modifier
                .height(128.dp),
        )
    }
}

@Suppress("MagicNumber")
@Preview(showBackground = true)
@Composable
fun Preview_YaaumPieChart_Light() {
    YaaumTheme(useDarkTheme = false) {
        YaaumPieChart(
            entries = listOf(
                CircleChartModel(Color.Red, 0.5f),
                CircleChartModel(Color.Green, 0.3f),
                CircleChartModel(Color.Blue, 0.2f),
            ),
            modifier = Modifier
                .height(128.dp),
        )
    }
}
