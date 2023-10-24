package dev.yaaum.repository.applications.impl

import dev.yaaum.data.repository.applications.ApplicationsRepository
import dev.yaaum.data.repository.applications.model.ApplicationsRepoModel
import dev.yaaum.data.repository.applications.model.toDatabaseModel
import dev.yaaum.data.repository.applications.model.toRepoModel
import dev.yaaum.data.source.database.applications.source.ApplicationsDatabaseSource
import dev.yaaum.data.source.system.applications.source.ApplicationsDataSource

@Suppress("UnusedPrivateProperty")
class ApplicationsRepositoryImpl(
    private val applicationsDataSource: ApplicationsDataSource,
    private val applicationsDatabaseSource: ApplicationsDatabaseSource,
) : ApplicationsRepository {
    override suspend fun getAllApplications(): List<ApplicationsRepoModel> {
        return applicationsDataSource.getAllApplications().map { it.toRepoModel() }
    }

    override suspend fun getUserApplications(): List<ApplicationsRepoModel> {
        return applicationsDataSource.getUserApplications().map { it.toRepoModel() }
    }

    override suspend fun markApplicationAsChosen(value: ApplicationsRepoModel) {
        applicationsDatabaseSource.insert(value.toDatabaseModel())
    }

    override suspend fun removeApplicationFromChosen(value: ApplicationsRepoModel) {
        value.applicationName?.let { applicationsDatabaseSource.delete(it) }
    }

    override suspend fun getAllChosenApplications(): List<ApplicationsRepoModel> {
        return applicationsDatabaseSource.get().map { it.toRepoModel() }
    }
}
