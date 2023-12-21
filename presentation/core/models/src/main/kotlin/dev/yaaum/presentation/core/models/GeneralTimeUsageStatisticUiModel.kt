package dev.yaaum.presentation.core.models

import dev.yaaum.domain.health.model.GeneralTimeUsageStatisticDomainModel
import dev.yaaum.presentation.core.models.base.BaseUiModel

/**
 * Contains information about:
 *
 * - total time usage of chosen application;
 * - total time usage of user's application;
 * - total time usage of all application;
 */
data class GeneralTimeUsageStatisticUiModel(
    val totalChosenAppsUsage: Long,
    val totalUsersAppsUsage: Long,
    val totalAppsUsage: Long,
) : BaseUiModel {

    val sum = (totalChosenAppsUsage + totalUsersAppsUsage + totalAppsUsage)

    val totalChosenAppsUsagePercent: Float
        get() {
            return (totalChosenAppsUsage.toFloat() / sum.toFloat())
        }

    val totalUsersAppsUsagePercent: Float
        get() {
            return (totalUsersAppsUsage.toFloat() / sum.toFloat())
        }

    val totalAppsUsagePercent: Float
        get() {
            return (totalUsersAppsUsage.toFloat() / sum.toFloat())
        }
}

/**
 * `GeneralTimeUsageStatisticDomainModel` -> `GeneralTimeUsageStatisticUiModel`
 */
fun GeneralTimeUsageStatisticDomainModel.toUiModel() = GeneralTimeUsageStatisticUiModel(
    totalChosenAppsUsage = (this.totalChosenAppsUsage ?: 0L),
    totalUsersAppsUsage = (this.totalUsersAppsUsage ?: 0L),
    totalAppsUsage = (this.totalAppsUsage ?: 0L),
)
