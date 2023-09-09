package dev.yaaum.data.system.timeusage.source

import arrow.core.raise.Raise
import dev.yaaum.data.system.timeusage.model.TimeUsageSystemModel

interface TimeUsageDataSource {
    context(Raise<String>)
    suspend fun getApplicationsUsage(): List<TimeUsageSystemModel>
//    fun Raise<String>.getApplicationsUsage(): MutableMap<String, UsageStats>?
}

data class Foo(val foo: String)
