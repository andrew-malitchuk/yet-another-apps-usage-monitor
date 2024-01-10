package dev.yaaum.repository.timeusage.impl

import dev.yaaum.data.repository.timeusage.TimeUsageRepository
import dev.yaaum.data.repository.timeusage.model.TimeUsageRepoModel
import dev.yaaum.data.repository.timeusage.model.toRepoModel
import dev.yaaum.data.source.system.timeusage.source.TimeUsageDataSource

class TimeUsageRepositoryImpl(
    private val timeUsageDataSource: TimeUsageDataSource,
) : TimeUsageRepository {

    override suspend fun getApplicationsUsage(): List<TimeUsageRepoModel> {
        return timeUsageDataSource.getApplicationsUsage().map { it.toRepoModel() }
    }

    override suspend fun getApplicationsUsage(
        beginTime: Long,
        endTime: Long,
    ): List<TimeUsageRepoModel> {
        return timeUsageDataSource.getApplicationsUsage(
            beginTime,
            endTime,
        ).map { it.toRepoModel() }
    }

    override suspend fun getApplicationUsage(
        packageName: String,
        beginTime: Long,
        endTime: Long,
    ): TimeUsageRepoModel? {
//        return timeUsageDataSource.getApplicationsUsage(
        return timeUsageDataSource.foo(
            packageName,
            beginTime,
            endTime,
        ).toRepoModel()
    }
}
