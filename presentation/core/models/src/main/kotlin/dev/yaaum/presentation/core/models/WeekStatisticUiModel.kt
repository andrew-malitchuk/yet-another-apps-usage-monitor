package dev.yaaum.presentation.core.models

import dev.yaaum.domain.core.model.BaseDomainModel
import dev.yaaum.domain.timeusage.model.WeekStatisticDomainModel

/**
 * App usage statistic for 7 days
 */
data class WeekStatisticUiModel(
    val applicationName: String?,
    val packageName: String?,
    val dayAndStatistic: Set<DayUsageStatisticUiModel>,
) : BaseDomainModel

/**
 * `WeekStatisticDomainModel` -> `WeekStatisticUiModel`
 */
fun WeekStatisticDomainModel.toUiModel() =
    WeekStatisticUiModel(
        applicationName = this.applicationName,
        packageName = this.packageName,
        dayAndStatistic = this.dayAndStatistic.map {
            it.toUiModel()
        }.toSet(),
    )
