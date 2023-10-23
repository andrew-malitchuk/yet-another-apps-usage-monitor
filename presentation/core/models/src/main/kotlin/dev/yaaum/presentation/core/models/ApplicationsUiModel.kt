package dev.yaaum.presentation.core.models

import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.core.model.BaseDomainModel

data class ApplicationsUiModel(
    val uuid: Int?,
    val packageName: String?,
    val applicationName: String?,
) : BaseDomainModel

/**
 * `ApplicationsDomainModel` -> `ApplicationsUiModel`
 */
fun ApplicationsDomainModel.toUiModel() =
    ApplicationsUiModel(
        uuid = this.uuid,
        packageName = this.packageName,
        applicationName = this.applicationName,
    )

/**
 * `ApplicationsUiModel` -> `ApplicationsDomainModel`
 */
fun ApplicationsUiModel.toDomainModel() =
    ApplicationsDomainModel(
        uuid = this.uuid,
        packageName = this.packageName,
        applicationName = this.applicationName,
    )
