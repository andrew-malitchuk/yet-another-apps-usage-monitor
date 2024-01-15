package dev.yaaum.data.source.system.timeusage.impl.source

import android.app.usage.UsageStatsManager
import android.content.Context
import dev.yaaum.data.source.system.timeusage.model.TimeUsageSystemModel
import dev.yaaum.data.source.system.timeusage.model.toSystemModel
import dev.yaaum.data.source.system.timeusage.source.TimeUsageDataSource
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class TimeUsageDataSourceImpl(
    private val context: Context,
) : TimeUsageDataSource {

    override suspend fun getApplicationsUsage(): List<TimeUsageSystemModel> {
        return suspendCoroutine { continuation ->
            val usageStatsManager =
                context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
            val usageStats = usageStatsManager.queryUsageStats(
                UsageStatsManager.INTERVAL_DAILY,
                0,
                System.currentTimeMillis(),
            )
            val result = ArrayList<TimeUsageSystemModel>()
            usageStats?.forEach {
                result.add(it.toSystemModel(context = context))
            }
            continuation.resume(result)
        }
    }

    override suspend fun getApplicationUsage(packageName: String): TimeUsageSystemModel {
        return suspendCoroutine { continuation ->
            val usageStatsManager =
                context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
            val usageStats = usageStatsManager.queryUsageStats(
                UsageStatsManager.INTERVAL_DAILY,
                0,
                System.currentTimeMillis(),
            ).first { it.packageName == packageName }
            continuation.resume(usageStats.toSystemModel(context))
        }
    }

    override suspend fun getApplicationsUsage(
        beginTime: Long,
        endTime: Long,
    ): List<TimeUsageSystemModel> {
        return suspendCoroutine { continuation ->
            val usageStatsManager =
                context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
            val usageStats = usageStatsManager.queryUsageStats(
                UsageStatsManager.INTERVAL_DAILY,
                beginTime,
                endTime,
            )
            val result = ArrayList<TimeUsageSystemModel>()
            usageStats?.forEach {
                result.add(it.toSystemModel(context = context))
            }
            continuation.resume(result)
        }
    }

    override suspend fun getApplicationUsage(
        packageName: String,
        beginTime: Long,
        endTime: Long,
    ): TimeUsageSystemModel? {
        return suspendCoroutine { continuation ->
            val usageStatsManager =
                context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
            val usageStats = usageStatsManager.queryUsageStats(
                UsageStatsManager.INTERVAL_DAILY,
                beginTime,
                endTime,
            ).firstOrNull { it.packageName == packageName }
            continuation.resume(usageStats?.toSystemModel(context))
        }
    }
}
