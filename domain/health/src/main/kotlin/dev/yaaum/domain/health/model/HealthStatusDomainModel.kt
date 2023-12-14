package dev.yaaum.domain.health.model

import dev.yaaum.domain.core.model.BaseDomainModel

data class HealthStatusDomainModel(
    /**
     * % of chosen apps usage by users app
     *
     * __Range:__ [0.0-1.0]
     */
    val percent: Float,
    val status: HealthStatus,
) : BaseDomainModel

// TODO: test
fun getStatus(percent: Float): HealthStatus {
    @Suppress("MagicNumber")
    return when (percent) {
        in (0.0f..0.1f) -> HealthStatus.SMILEY
        in (0.1f..0.3f) -> HealthStatus.ANGRY
        in (0.3f..0.4f) -> HealthStatus.BLANK
        in (0.4f..0.5f) -> HealthStatus.MEH
        in (0.5f..0.7f) -> HealthStatus.SAD
        in (0.7f..0.8f) -> HealthStatus.WINK
        in (0.8f..0.9f) -> HealthStatus.DAMN
        in (0.9f..1f) -> HealthStatus.NERVOUS
        else -> HealthStatus.NERVOUS
    }
}

enum class HealthStatus {
    NERVOUS,
    SMILEY,
    ANGRY,
    BLANK,
    MEH,
    SAD,
    WINK,
    DAMN,
}
