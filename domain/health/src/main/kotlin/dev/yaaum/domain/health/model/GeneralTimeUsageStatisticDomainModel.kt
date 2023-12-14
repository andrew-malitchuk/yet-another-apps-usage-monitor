package dev.yaaum.domain.health.model

import dev.yaaum.domain.core.model.BaseDomainModel

/**
 * Contains information about:
 *
 * - total time usage of chosen application;
 * - total time usage of user's application;
 * - total time usage of all application;
 */
data class GeneralTimeUsageStatisticDomainModel(
    val totalChosenAppsUsage: Long?,
    val totalUsersAppsUsage: Long?,
    val totalAppsUsage: Long?,
) : BaseDomainModel
