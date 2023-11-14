package dev.yaaum.presentation.core.ui.composable.chart

@Suppress("MagicNumber")
fun calculateStartAngles(entries: List<CircleChartModel>): List<Float> {
    var totalPercentage = 0f
    return entries.map { entry ->
        val startAngle = totalPercentage * 360
        totalPercentage += entry.percentage
        startAngle
    }
}
