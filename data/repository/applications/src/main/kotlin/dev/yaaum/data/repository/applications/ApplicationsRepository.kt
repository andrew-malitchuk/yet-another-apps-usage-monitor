package dev.yaaum.data.repository.applications

import dev.yaaum.data.core.exception.base.BaseDataException
import dev.yaaum.data.repository.applications.model.ApplicationsRepoModel
import kotlin.jvm.Throws

/**
 * Provides all available operations with application (system's and/or user's)
 */
interface ApplicationsRepository {

    /**
     * Returns __all__ applications on device
     *
     * @return all applications
     *
     * @throws BaseDataException
     */
    @Throws(BaseDataException::class)
    suspend fun getAllApplications(): List<ApplicationsRepoModel>

    /**
     * Returns __user's__ applications
     *
     * @return user application
     *
     * @throws BaseDataException
     */
    @Throws(BaseDataException::class)
    suspend fun getUserApplications(): List<ApplicationsRepoModel>

    /**
     * Save [value] to local db; in such way, app makes [value] "chosen";
     *
     * > Chosen - application which is marked to be tracked
     *
     * @param value app to make "chosen"
     *
     * @throws BaseDataException
     */
    @Throws(BaseDataException::class)
    suspend fun markApplicationAsChosen(value: ApplicationsRepoModel)

    /**
     * Remove [value] (a.k.a. "chosen" application) from local db
     *
     * > Chosen - application which is marked to be tracked
     *
     * @param value app to remove from "chosen" list
     *
     * @throws BaseDataException
     */
    @Throws(BaseDataException::class)
    suspend fun removeApplicationFromChosen(value: ApplicationsRepoModel)

    /**
     * Get all applications which  are marked as "chosen"
     *
     * > Chosen - application which is marked to be tracked
     *
     * @return "chosen" application
     *
     * @throws BaseDataException
     */
    @Throws(BaseDataException::class)
    suspend fun getAllChosenApplications(): List<ApplicationsRepoModel>
}
