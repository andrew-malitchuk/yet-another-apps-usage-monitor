package dev.yaaum.presentation.core.ui.composable.chart

/**
 * Do calculation for chart
 *
 * @param entries
 * @return angle
 */
// TODO: test me
@Suppress("MagicNumber")
fun calculateStartAngles(entries: List<CircleChartModel>): List<Float> {
    var totalPercentage = 0f
    return entries.map { entry ->
        val startAngle = totalPercentage * 360
        totalPercentage += entry.percentage
        startAngle
    }
}
