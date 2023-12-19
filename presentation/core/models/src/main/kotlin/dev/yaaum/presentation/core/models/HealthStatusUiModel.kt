package dev.yaaum.presentation.core.models

import dev.yaaum.domain.health.model.HealthStatusDomainModel
import dev.yaaum.presentation.core.models.base.BaseUiModel

/**
 * Container for app usage statistic. (In other words, wrapper over `UsageStats`).
 */
data class HealthStatusUiModel(
    /**
     * % of chosen apps usage by users app
     *
     * __Range:__ [0.0-1.0]
     */
    val percent: Float,
    val status: HealthStatus,
) : BaseUiModel

/**
 * `HealthStatusUiModel` -> `HealthStatusUiModel`
 */
fun HealthStatusDomainModel.toUiModel() =
    HealthStatusUiModel(
        percent = this.percent,

        status = this.status,
    )
