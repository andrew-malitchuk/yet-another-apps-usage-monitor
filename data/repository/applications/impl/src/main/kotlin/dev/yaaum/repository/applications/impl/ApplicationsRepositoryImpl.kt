package dev.yaaum.repository.applications.impl

import dev.yaaum.data.repository.applications.ApplicationsRepository
import dev.yaaum.data.repository.applications.model.ApplicationsRepoModel
import dev.yaaum.data.repository.applications.model.toRepoModel
import dev.yaaum.data.source.system.applications.source.ApplicationsDataSource

class ApplicationsRepositoryImpl(
    private val applicationsDataSource: ApplicationsDataSource,
) : ApplicationsRepository {
    override suspend fun getAllApplications(): List<ApplicationsRepoModel> {
        return applicationsDataSource.getAllApplications().map { it.toRepoModel() }
    }

    override suspend fun getUserApplications(): List<ApplicationsRepoModel> {
        return applicationsDataSource.getUserApplications().map { it.toRepoModel() }
    }
}