package dev.yaaum.data.system.timeusage.source

import arrow.core.raise.Raise
import dev.yaaum.data.system.core.exception.base.BaseSystemException
import dev.yaaum.data.system.timeusage.model.TimeUsageSystemModel

/**
 * Lazy wrapper over system call for Application Usage API
 */
interface TimeUsageDataSource {

    /**
     * Retrieve general information about application usage.
     * Returns about __all__ application.
     *
     * @receiver hypothetical exception
     * @return list of app usage info
     */
    context(Raise<BaseSystemException>)
    suspend fun getApplicationsUsage(): List<TimeUsageSystemModel>
}
