package dev.yaaum.data.repository.timeusage.model

import dev.yaaum.data.repository.core.model.base.BaseRepoModel
import dev.yaaum.data.source.system.timeusage.model.TimeUsageSystemModel

/**
 * Container for app usage statistic. (In other words, wrapper over `UsageStats`).
 */
data class TimeUsageRepoModel(
    val packageName: String?,
    val usageBegin: Long?,
    val usageEnd: Long?,
    val lastTimeUsage: Long?,
    val totalTimeInForeground: Long?,
) : BaseRepoModel

/**
 * `TimeUsageSystemModel` -> `TimeUsageRepoModel`
 */
fun TimeUsageSystemModel.toRepoModel() =
    TimeUsageRepoModel(
        packageName = this.packageName,
        usageBegin = this.usageBegin,
        usageEnd = this.usageEnd,
        lastTimeUsage = this.lastTimeUsage,
        totalTimeInForeground = this.totalTimeInForeground,
    )
