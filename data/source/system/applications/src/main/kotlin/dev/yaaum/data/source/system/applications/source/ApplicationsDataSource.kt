package dev.yaaum.data.source.system.applications.source

import dev.yaaum.data.core.exception.base.BaseDataException
import dev.yaaum.data.source.system.applications.model.ApplicationSystemModel
import kotlin.jvm.Throws

interface ApplicationsDataSource {
    @Throws(BaseDataException::class)
    suspend fun getAllApplications(): List<ApplicationSystemModel>

    @Throws(BaseDataException::class)
    suspend fun getUserApplications(): List<ApplicationSystemModel>
}
