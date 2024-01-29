package dev.yaaum.presentation.core.models

import dev.yaaum.common.core.ext.asHours
import dev.yaaum.domain.timeusage.model.DayUsageStatisticDomainModel
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.base.BaseUiModel

/**
 * Simple wrapper for per day usage info
 */
data class DayUsageStatisticUiModel(
    val weekDay: UiText,
    val appUsage: Long,
    val appUsageHours: String,
) : BaseUiModel

/**
 * `DayUsageStatisticDomainModel` -> `DayUsageStatisticUiModel`
 */
fun DayUsageStatisticDomainModel.toUiModel() =
    DayUsageStatisticUiModel(
        weekDay = getWeekDay(this.weekDay),
        // TODO: fix
        appUsage = this.appUsage,
        appUsageHours = this.appUsage.asHours(),
    )

// TODO: test
@Suppress("MagicNumber")
fun getWeekDay(weekDay: Int): UiText {
    return when (weekDay) {
        2 -> UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.various_mon)
        3 -> UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.various_tue)
        4 -> UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.various_wed)
        5 -> UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.various_thu)
        6 -> UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.various_fri)
        7 -> UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.various_sat)
        1 -> UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.various_sun)
        else -> UiText.DynamicString("NI")
    }
}
