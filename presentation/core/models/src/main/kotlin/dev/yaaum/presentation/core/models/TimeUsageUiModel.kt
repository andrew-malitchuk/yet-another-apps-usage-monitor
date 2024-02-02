package dev.yaaum.presentation.core.models

import dev.yaaum.common.core.ext.asHours
import dev.yaaum.domain.timeusage.model.TimeUsageDomainModel
import dev.yaaum.presentation.core.models.base.BaseUiModel

/**
 * Container for app usage statistic. (In other words, wrapper over `UsageStats`).
 */
data class TimeUsageUiModel(
    val applicationName: String?,
    val packageName: String?,
    val usageBegin: Long?,
    val usageEnd: Long?,
    val totalTimeInForeground: Long?,
) : BaseUiModel {

    val totalTimeInForegroundHumanReadable: String
        get() {
            return "${totalTimeInForeground?.asHours()} h"
        }
}

/**
 * `TimeUsageRepoModel` -> `TimeUsageDomainModel`
 */
fun TimeUsageDomainModel.toUiModel() =
    TimeUsageUiModel(
        packageName = this.packageName,
        usageBegin = this.usageBegin,
        usageEnd = this.usageEnd,
        totalTimeInForeground = this.totalTimeInForeground,
        applicationName = applicationName,
    )
