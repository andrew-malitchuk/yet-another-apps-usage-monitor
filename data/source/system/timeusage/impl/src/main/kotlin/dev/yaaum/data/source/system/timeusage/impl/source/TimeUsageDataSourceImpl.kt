package dev.yaaum.data.source.system.timeusage.impl.source

import android.app.usage.UsageStatsManager
import android.content.Context
import androidx.activity.ComponentActivity
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
            val lUsageStatsMap =
                (context.getSystemService(ComponentActivity.USAGE_STATS_SERVICE) as? UsageStatsManager)
                    ?.queryAndAggregateUsageStats(
                        0,
                        System.currentTimeMillis(),
                    )
            val result = ArrayList<TimeUsageSystemModel>()
            lUsageStatsMap?.forEach { (_, u) ->
                try {
                    result.add(u.toSystemModel(context = context))
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
            continuation.resume(result)
        }
    }

    override suspend fun getApplicationsUsage(
        beginTime: Long,
        endTime: Long,
    ): List<TimeUsageSystemModel> {
        return suspendCoroutine { continuation ->
            val lUsageStatsMap =
                (context.getSystemService(ComponentActivity.USAGE_STATS_SERVICE) as? UsageStatsManager)
                    ?.queryAndAggregateUsageStats(
                        beginTime,
                        endTime,
                    )
            val result = ArrayList<TimeUsageSystemModel>()
            lUsageStatsMap?.forEach { (_, u) ->
                result.add(u.toSystemModel(context = context))
            }
            continuation.resume(result)
        }
    }
}
