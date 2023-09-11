package dev.yaaum.data.repository.timeusage

import arrow.core.raise.Raise
import dev.yaaum.data.repository.core.exception.base.BaseRepoException
import dev.yaaum.data.repository.timeusage.model.TimeUsageRepoModel

/**
 * Lazy wrapper over system call for Application Usage API
 */
interface TimeUsageRepository {

    /**
     * Retrieve general information about application usage.
     * Returns about __all__ application.
     *
     * @receiver hypothetical exception
     * @return list of app usage info
     */
    context(Raise<BaseRepoException>)
    suspend fun getApplicationsUsage(): List<TimeUsageRepoModel>
}
