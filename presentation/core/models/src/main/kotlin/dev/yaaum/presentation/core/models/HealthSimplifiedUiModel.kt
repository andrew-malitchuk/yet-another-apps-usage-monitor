package dev.yaaum.presentation.core.models

import dev.yaaum.presentation.core.models.base.BaseUiModel

/**
 * Represent simplified information about "user's health" according to apps usage statistic
 */
data class HealthSimplifiedUiModel(
    val status: HealthStatus,
    val title: String,
    val description: String,
) : BaseUiModel

/**
 * Health's type
 */
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
