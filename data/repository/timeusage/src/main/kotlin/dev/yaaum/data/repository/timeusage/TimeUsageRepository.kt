package dev.yaaum.data.repository.timeusage

import dev.yaaum.data.repository.core.exception.base.BaseRepoException
import dev.yaaum.data.repository.timeusage.model.TimeUsageRepoModel
import kotlin.jvm.Throws

/**
 * Lazy wrapper over system call for Application Usage API
 */
interface TimeUsageRepository {

    /**
     * Retrieve general information about application usage.
     * Returns about __all__ application.
     *
     * @return list of app usage info
     *
     * @throws BaseRepoException
     */
    @Throws(BaseRepoException::class)
    suspend fun getApplicationsUsage(): List<TimeUsageRepoModel>
}
