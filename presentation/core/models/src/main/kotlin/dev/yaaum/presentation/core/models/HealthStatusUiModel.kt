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
        status = this.status.toUiModel(),
    )

fun dev.yaaum.domain.health.model.HealthStatus.toUiModel(): HealthStatus {
    return when (this) {
        dev.yaaum.domain.health.model.HealthStatus.NERVOUS -> HealthStatus.NERVOUS
        dev.yaaum.domain.health.model.HealthStatus.SMILEY -> HealthStatus.SMILEY
        dev.yaaum.domain.health.model.HealthStatus.ANGRY -> HealthStatus.ANGRY
        dev.yaaum.domain.health.model.HealthStatus.BLANK -> HealthStatus.BLANK
        dev.yaaum.domain.health.model.HealthStatus.MEH -> HealthStatus.MEH
        dev.yaaum.domain.health.model.HealthStatus.SAD -> HealthStatus.SAD
        dev.yaaum.domain.health.model.HealthStatus.WINK -> HealthStatus.WINK
        dev.yaaum.domain.health.model.HealthStatus.DAMN -> HealthStatus.DAMN
    }
}
