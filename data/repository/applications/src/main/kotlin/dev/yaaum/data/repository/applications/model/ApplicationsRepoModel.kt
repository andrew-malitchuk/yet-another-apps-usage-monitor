package dev.yaaum.data.repository.applications.model

import dev.yaaum.data.repository.core.model.base.BaseRepoModel
import dev.yaaum.data.source.database.applications.model.ApplicationsDatabaseModel
import dev.yaaum.data.source.system.applications.model.ApplicationSystemModel

/**
 * Represent information about application
 */
data class ApplicationsRepoModel(
    val uuid: Int?,
    val packageName: String?,
    val applicationName: String?,
) : BaseRepoModel

/**
 * `ApplicationSystemModel` -> `ApplicationsRepoModel`
 */
fun ApplicationSystemModel.toRepoModel() =
    ApplicationsRepoModel(
        uuid = this.uuid,
        packageName = this.packageName,
        applicationName = this.applicationName,
    )

/**
 * `ApplicationsDatabaseModel` -> `ApplicationsRepoModel`
 */
fun ApplicationsDatabaseModel.toRepoModel() =
    ApplicationsRepoModel(
        uuid = this.uuid,
        packageName = this.packageName,
        applicationName = this.applicationName,
    )

/**
 * `ApplicationsRepoModel` -> `ApplicationsDatabaseModel`
 */
fun ApplicationsRepoModel.toDatabaseModel() =
    ApplicationsDatabaseModel(
        uuid = this.uuid ?: -1,
        packageName = this.packageName ?: "",
        applicationName = this.applicationName ?: "",
    )
