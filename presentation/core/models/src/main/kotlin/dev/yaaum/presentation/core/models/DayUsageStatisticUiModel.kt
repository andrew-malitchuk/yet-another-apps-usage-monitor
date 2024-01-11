package dev.yaaum.presentation.core.models

import dev.yaaum.domain.timeusage.model.DayUsageStatisticDomainModel
import dev.yaaum.presentation.core.models.base.BaseUiModel

/**
 * Simple wrapper for per day usage info
 */
data class DayUsageStatisticUiModel(
    val weekDay: Int,
    val appUsage: Long,
) : BaseUiModel

/**
 * `DayUsageStatisticDomainModel` -> `DayUsageStatisticUiModel`
 */
fun DayUsageStatisticDomainModel.toUiModel() =
    DayUsageStatisticUiModel(
        weekDay = this.weekDay,
        // TODO: fix
        appUsage = this.appUsage,
    )
