package dev.yaaum.data.system.timeusage.impl.source

import android.app.usage.UsageStatsManager
import android.content.Context
import androidx.activity.ComponentActivity
import arrow.core.raise.Raise
import dev.yaaum.data.system.core.exception.base.BaseSystemException
import dev.yaaum.data.system.timeusage.model.TimeUsageSystemModel
import dev.yaaum.data.system.timeusage.model.toSystemModel
import dev.yaaum.data.system.timeusage.source.TimeUsageDataSource
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class TimeUsageDataSourceImpl(
    private val context: Context,
) : TimeUsageDataSource {
    context(Raise<BaseSystemException>)
    override suspend fun getApplicationsUsage(): List<TimeUsageSystemModel> {
        return suspendCoroutine { continuation ->
            try {
                val lUsageStatsMap =
                    (context.getSystemService(ComponentActivity.USAGE_STATS_SERVICE) as? UsageStatsManager)
                        ?.queryAndAggregateUsageStats(
                            0,
                            System.currentTimeMillis(),
                        )
                val result = ArrayList<TimeUsageSystemModel>()
                lUsageStatsMap?.forEach { (t, u) ->
                    result.add(u.toSystemModel())
                }
                continuation.resume(result)
            } catch (ex: Exception) {
                // TODO: fix
                @Suppress("InstanceOfCheckForException")
                raise((ex as BaseSystemException))
            }
        }
    }
}
