package dev.yaaum.presentation.core.ui.composable.chart.donut

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.composable.chart.CircleChartModel
import dev.yaaum.presentation.core.ui.composable.chart.calculateStartAngles
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

/**
 * Chart diagram
 *
 * @param modifier
 * @param entries content to display
 */
@Suppress("MagicNumber")
@Composable
fun YaaumChartDonut(
    modifier: Modifier = Modifier,
    entries: List<CircleChartModel>,
) {
    Canvas(
        modifier = modifier
            .aspectRatio(1f),
        onDraw = {
            val width = size.width
            val radius = width / 2f
            val strokeWidth = radius * .3f
            val startAngles = calculateStartAngles(entries)
            val gap = 25f
            entries.forEachIndexed { index, entry ->
                drawArc(
                    color = entry.color,
                    startAngle = startAngles[index] + gap,
                    sweepAngle = entry.percentage * 360f - gap,
                    useCenter = false,
                    topLeft = Offset(strokeWidth / 2, strokeWidth / 2),
                    size = Size(width - strokeWidth, width - strokeWidth),
                    style = Stroke(strokeWidth, cap = StrokeCap.Round),
                )
            }
        },
    )
}

@Suppress("MagicNumber")
@Preview(showBackground = true)
@Composable
fun Preview_YaaumChartDonut_Dark() {
    YaaumTheme(useDarkTheme = true) {
        YaaumChartDonut(
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
fun Preview_YaaumChartDonut_Light() {
    YaaumTheme(useDarkTheme = false) {
        YaaumChartDonut(
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
