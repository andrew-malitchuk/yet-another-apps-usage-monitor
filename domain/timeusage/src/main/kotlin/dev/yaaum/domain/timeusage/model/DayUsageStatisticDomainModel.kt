package dev.yaaum.domain.timeusage.model

import dev.yaaum.domain.core.model.BaseDomainModel

/**
 * Simple wrapper for per day usage info
 */
data class DayUsageStatisticDomainModel(
    val weekDay: String,
    val appUsage: Long,
) : BaseDomainModel
