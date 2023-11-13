package dev.yaaum.presentation.core.ui.composable.chart.donut

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke

@Suppress("MagicNumber")
@Composable
fun Chart(
    modifier: Modifier = Modifier,
) {
    Canvas(
        modifier = modifier
            .aspectRatio(1f),
        onDraw = {
            val width = size.width
            val radius = width / 2f
            val strokeWidth = radius * .3f
            var startAngle = 0f

            val items = listOf(100f, 50f)

            items.forEach {
                val sweepAngle = it.toAngle
                val gap = 25f / 2
                drawArc(
                    color = Color.Gray,
                    startAngle = startAngle + gap,
                    sweepAngle = sweepAngle - gap * 2,
                    useCenter = false,
                    topLeft = Offset(strokeWidth / 2, strokeWidth / 2),
                    size = Size(width - strokeWidth, width - strokeWidth),
                    style = Stroke(strokeWidth, cap = StrokeCap.Round),
                )

                startAngle += sweepAngle
            }
        },

    )
}

@Suppress("MagicNumber")
private val Float.toAngle: Float
    get() = this * 180 / 100
