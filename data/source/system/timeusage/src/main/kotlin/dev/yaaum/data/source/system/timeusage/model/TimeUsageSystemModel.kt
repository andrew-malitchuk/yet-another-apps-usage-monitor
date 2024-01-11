package dev.yaaum.data.source.system.timeusage.model

import android.app.usage.UsageStats
import android.content.Context
import dev.yaaum.data.source.system.core.model.base.BaseSystemModel

/**
 * Container for app usage statistic. (In other words, wrapper over `UsageStats`).
 */
data class TimeUsageSystemModel(
    val applicationName: String?,
    val packageName: String?,
    val usageBegin: Long?,
    val usageEnd: Long?,
    val totalTimeInForeground: Long?,
) : BaseSystemModel

/**
 * `UsageStats` -> `TimeUsageSystemModel`
 */
fun UsageStats.toSystemModel(context: Context): TimeUsageSystemModel {
    val applicationName = try {
        context.packageManager.getApplicationInfo(packageName, 0).loadLabel(context.packageManager)
            .toString()
    } catch (ex: Exception) {
        null
    }
    return TimeUsageSystemModel(
        applicationName = applicationName ?: this.packageName,
        packageName = this.packageName,
        usageBegin = this.firstTimeStamp,
        usageEnd = this.lastTimeStamp,
        totalTimeInForeground = this.totalTimeInForeground,
    )
}
