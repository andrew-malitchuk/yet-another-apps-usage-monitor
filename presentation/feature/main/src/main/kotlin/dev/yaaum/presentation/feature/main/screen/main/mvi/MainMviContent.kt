package dev.yaaum.presentation.feature.main.screen.main.mvi

import dev.yaaum.presentation.core.models.GeneralTimeUsageStatisticUiModel
import dev.yaaum.presentation.core.models.HealthStatusUiModel
import dev.yaaum.presentation.core.models.RecommendationUiModel
import dev.yaaum.presentation.core.models.TimeUsageUiModel
import dev.yaaum.presentation.core.platform.mvi.state.content.MviContent

data class MainMviContent(
    val topUsageApps: List<TimeUsageUiModel>? = null,
    val healthStatus: HealthStatusUiModel? = null,
    val timeUsage: GeneralTimeUsageStatisticUiModel? = null,
    val recommendations: List<RecommendationUiModel>? = null,
) : MviContent
