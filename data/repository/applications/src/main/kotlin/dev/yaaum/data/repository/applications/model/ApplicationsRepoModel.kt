package dev.yaaum.data.repository.applications.model

import dev.yaaum.data.repository.core.model.base.BaseRepoModel
import dev.yaaum.data.source.system.applications.model.ApplicationSystemModel

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
