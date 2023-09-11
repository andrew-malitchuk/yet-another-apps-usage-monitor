package dev.yaaum.domain.timeusage.model

import dev.yaaum.data.repository.timeusage.model.TimeUsageRepoModel
import dev.yaaum.domain.core.model.BaseDomainModel

/**
 * Container for app usage statistic. (In other words, wrapper over `UsageStats`).
 */
data class TimeUsageDomainModel(
    val packageName: String?,
    val usageBegin: Long?,
    val usageEnd: Long?,
    val lastTimeUsage: Long?,
    val totalTimeInForeground: Long?,
) : BaseDomainModel

/**
 * `TimeUsageRepoModel` -> `TimeUsageDomainModel`
 */
fun TimeUsageRepoModel.toDomainModel() =
    TimeUsageDomainModel(
        packageName = this.packageName,
        usageBegin = this.usageBegin,
        usageEnd = this.usageEnd,
        lastTimeUsage = this.lastTimeUsage,
        totalTimeInForeground = this.totalTimeInForeground,
    )
