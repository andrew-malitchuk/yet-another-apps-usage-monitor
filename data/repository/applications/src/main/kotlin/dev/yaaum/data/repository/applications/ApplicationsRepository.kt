package dev.yaaum.data.repository.applications

import dev.yaaum.data.core.exception.base.BaseDataException
import dev.yaaum.data.repository.applications.model.ApplicationsRepoModel
import kotlin.jvm.Throws

interface ApplicationsRepository {
    @Throws(BaseDataException::class)
    suspend fun getAllApplications(): List<ApplicationsRepoModel>

    @Throws(BaseDataException::class)
    suspend fun getUserApplications(): List<ApplicationsRepoModel>

    @Throws(BaseDataException::class)
    suspend fun markApplicationAsChosen(value: ApplicationsRepoModel)

    @Throws(BaseDataException::class)
    suspend fun removeApplicationFromChosen(value: ApplicationsRepoModel)

    @Throws(BaseDataException::class)
    suspend fun getAllChosenApplications(): List<ApplicationsRepoModel>
}
