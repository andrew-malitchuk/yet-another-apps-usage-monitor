package dev.yaaum.domain.timeusage.model

import dev.yaaum.domain.core.model.BaseDomainModel

/**
 * App usage statistic for 7 days
 */
data class WeekStatisticDomainModel(
    val applicationName: String?,
    val packageName: String?,
    val dayAndStatistic: List<DayUsageStatisticDomainModel>,
) : BaseDomainModel
