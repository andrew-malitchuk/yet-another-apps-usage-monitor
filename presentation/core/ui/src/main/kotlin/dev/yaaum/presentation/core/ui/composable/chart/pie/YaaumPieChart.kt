package dev.yaaum.presentation.core.ui.composable.chart.pie

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import dev.yaaum.presentation.core.ui.composable.chart.CircleChartModel
import dev.yaaum.presentation.core.ui.composable.chart.calculateStartAngles

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
