package dev.yaaum.data.source.system.applications.source

import dev.yaaum.data.core.exception.base.BaseDataException
import dev.yaaum.data.source.system.applications.model.ApplicationSystemModel
import kotlin.jvm.Throws

/**
 * Abstraction over system provider.
 *
 * Provides all system information about applications on device
 */
interface ApplicationsDataSource {

    /**
     * Returns __all__ applications on device
     *
     * @return all applications
     *
     * @throws BaseDataException
     */
    @Throws(BaseDataException::class)
    suspend fun getAllApplications(): List<ApplicationSystemModel>

    /**
     * Returns __user's__ applications
     *
     * @return user application
     *
     * @throws BaseDataException
     */
    @Throws(BaseDataException::class)
    suspend fun getUserApplications(): List<ApplicationSystemModel>
}
