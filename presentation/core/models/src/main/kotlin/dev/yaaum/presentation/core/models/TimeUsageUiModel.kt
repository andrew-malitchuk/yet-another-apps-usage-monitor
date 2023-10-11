package dev.yaaum.presentation.core.models

import dev.yaaum.domain.timeusage.model.TimeUsageDomainModel
import dev.yaaum.presentation.core.models.base.BaseUiModel

/**
 * Container for app usage statistic. (In other words, wrapper over `UsageStats`).
 */
data class TimeUsageUiModel(
    val packageName: String?,
    val usageBegin: Long?,
    val usageEnd: Long?,
    val lastTimeUsage: Long?,
    val totalTimeInForeground: Long?,
) : BaseUiModel

/**
 * `TimeUsageRepoModel` -> `TimeUsageDomainModel`
 */
fun TimeUsageDomainModel.toUiModel() =
    TimeUsageUiModel(
        packageName = this.packageName,
        usageBegin = this.usageBegin,
        usageEnd = this.usageEnd,
        lastTimeUsage = this.lastTimeUsage,
        totalTimeInForeground = this.totalTimeInForeground,
    )
