package dev.yaaum.data.source.system.timeusage.model

import android.app.usage.UsageStats
import dev.yaaum.data.source.system.core.model.base.BaseSystemModel

/**
 * Container for app usage statistic. (In other words, wrapper over `UsageStats`).
 */
data class TimeUsageSystemModel(
    val packageName: String?,
    val usageBegin: Long?,
    val usageEnd: Long?,
    val lastTimeUsage: Long?,
    val totalTimeInForeground: Long?,
) : BaseSystemModel

/**
 * `UsageStats` -> `TimeUsageSystemModel`
 */
fun UsageStats.toSystemModel() =
    TimeUsageSystemModel(
        packageName = this.packageName,
        usageBegin = this.firstTimeStamp,
        usageEnd = this.lastTimeStamp,
        lastTimeUsage = this.lastTimeUsed,
        totalTimeInForeground = this.totalTimeInForeground,
    )
