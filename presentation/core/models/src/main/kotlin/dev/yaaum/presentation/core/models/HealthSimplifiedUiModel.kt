package dev.yaaum.presentation.core.models

import dev.yaaum.presentation.core.models.base.BaseUiModel

data class HealthSimplifiedUiModel(
    val status: HealthStatus,
    val title: String,
    val description: String,
) : BaseUiModel

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
