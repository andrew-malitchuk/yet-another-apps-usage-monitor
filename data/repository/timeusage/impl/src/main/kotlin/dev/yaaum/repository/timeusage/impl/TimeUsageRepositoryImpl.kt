package dev.yaaum.repository.timeusage.impl

import arrow.core.raise.Raise
import arrow.core.raise.fold
import dev.yaaum.data.repository.core.exception.base.BaseRepoException
import dev.yaaum.data.repository.timeusage.TimeUsageRepository
import dev.yaaum.data.repository.timeusage.model.TimeUsageRepoModel
import dev.yaaum.data.repository.timeusage.model.toRepoModel
import dev.yaaum.data.source.system.timeusage.source.TimeUsageDataSource

class TimeUsageRepositoryImpl(
    private val timeUsageDataSource: TimeUsageDataSource,
) : TimeUsageRepository {

    context(Raise<BaseRepoException>)
    override suspend fun getApplicationsUsage(): List<TimeUsageRepoModel> {
        fold({
            timeUsageDataSource.getApplicationsUsage()
        }, { error ->
            // TODO: fix
            raise(error as BaseRepoException)
        }, { result ->
            return result.map { it.toRepoModel() }
        })
    }
}
