package dev.yaaum.data.source.system.timeusage.source

import dev.yaaum.data.source.system.core.exception.base.BaseSystemException
import dev.yaaum.data.source.system.timeusage.model.TimeUsageSystemModel
import kotlin.jvm.Throws

/**
 * Lazy wrapper over system call for Application Usage API
 */
interface TimeUsageDataSource {

    /**
     * Retrieve general information about application usage.
     * Returns about __all__ application.
     *
     * @return list of app usage info
     *
     * @throws BaseSystemException
     */
    @Throws(BaseSystemException::class)
    suspend fun getApplicationsUsage(): List<TimeUsageSystemModel>
}
