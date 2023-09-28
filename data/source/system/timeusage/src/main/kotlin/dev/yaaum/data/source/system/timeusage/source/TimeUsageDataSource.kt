package dev.yaaum.data.source.system.timeusage.source

import dev.yaaum.data.core.exception.base.BaseDataException
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
     * @throws BaseDataException
     */
    @Throws(BaseDataException::class)
    suspend fun getApplicationsUsage(): List<TimeUsageSystemModel>
}