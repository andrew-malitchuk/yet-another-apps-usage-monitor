package dev.yaaum.presentation.core.ui.composable.chart.donut

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import dev.yaaum.presentation.core.ui.composable.chart.CircleChartModel
import dev.yaaum.presentation.core.ui.composable.chart.calculateStartAngles

@Suppress("MagicNumber")
@Composable
fun YaaumChartDonut(
    entries: List<CircleChartModel>,
    modifier: Modifier = Modifier,
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
