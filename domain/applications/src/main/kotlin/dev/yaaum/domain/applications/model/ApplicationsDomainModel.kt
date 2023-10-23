package dev.yaaum.domain.applications.model

import dev.yaaum.data.repository.applications.model.ApplicationsRepoModel
import dev.yaaum.domain.core.model.BaseDomainModel

data class ApplicationsDomainModel(
    val uuid: Int?,
    val packageName: String?,
    val applicationName: String?,
) : BaseDomainModel

/**
 * `ApplicationsRepoModel` -> `ApplicationsDomainModel`
 */
fun ApplicationsRepoModel.toDomainModel() =
    ApplicationsDomainModel(
        uuid = this.uuid,
        packageName = this.packageName,
        applicationName = this.applicationName,
    )

/**
 * `ApplicationsDomainModel` -> `ApplicationsRepoModel`
 */
fun ApplicationsDomainModel.toRepoModel() =
    ApplicationsRepoModel(
        uuid = this.uuid,
        packageName = this.packageName,
        applicationName = this.applicationName,
    )
