package dev.yaaum.presentation.core.models

import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.presentation.core.models.base.BaseUiModel

/**
 * Represent information about application
 */
data class ApplicationsUiModel(
    val uuid: Int?,
    val packageName: String?,
    val applicationName: String?,
    // TODO: fix to immutable
    var isChosen: Boolean = false,
) : BaseUiModel

/**
 * `ApplicationsDomainModel` -> `ApplicationsUiModel`
 */
fun ApplicationsDomainModel.toUiModel() =
    ApplicationsUiModel(
        uuid = this.uuid,
        packageName = this.packageName,
        applicationName = this.applicationName,
        isChosen = this.isChosen,
    )

/**
 * `ApplicationsUiModel` -> `ApplicationsDomainModel`
 */
fun ApplicationsUiModel.toDomainModel() =
    ApplicationsDomainModel(
        uuid = this.uuid,
        packageName = this.packageName,
        applicationName = this.applicationName,
        isChosen = this.isChosen,
    )
