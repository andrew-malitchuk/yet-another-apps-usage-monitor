package dev.yaaum.data.system.timeusage.model

import android.app.usage.UsageStats
import dev.yaaum.data.system.core.model.base.BaseSystemModel

data class TimeUsageSystemModel(
    val packageName: String?,
    val usageBegin: Long?,
    val usageEnd: Long?,
    val lastTimeUsage: Long?,
    val totalTimeInForeground: Long?,
) : BaseSystemModel

fun UsageStats.toSystemModel() =
    TimeUsageSystemModel(
        packageName = this.packageName,
        usageBegin = this.firstTimeStamp,
        usageEnd = this.lastTimeStamp,
        lastTimeUsage = this.lastTimeUsed,
        totalTimeInForeground = this.totalTimeInForeground,
    )
