package dev.yaaum.presentation.core.models

import dev.yaaum.domain.timeusage.model.DayUsageStatisticDomainModel
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.base.BaseUiModel

/**
 * Simple wrapper for per day usage info
 */
data class DayUsageStatisticUiModel(
    val weekDay: UiText,
    val appUsage: Long,
) : BaseUiModel

/**
 * `DayUsageStatisticDomainModel` -> `DayUsageStatisticUiModel`
 */
fun DayUsageStatisticDomainModel.toUiModel() =
    DayUsageStatisticUiModel(
        weekDay = getWeekDay(this.weekDay),
        // TODO: fix
        appUsage = this.appUsage,
    )

// TODO: test
@Suppress("MagicNumber")
fun getWeekDay(weekDay: Int): UiText {
    return when (weekDay) {
        1 -> UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.various_mon)
        2 -> UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.various_tue)
        3 -> UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.various_wed)
        4 -> UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.various_thu)
        5 -> UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.various_fri)
        6 -> UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.various_sat)
        else -> UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.various_sun)
    }
}
