package dev.yaaum.presentation.feature.health.screen.health.mvi

import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.models.GeneralTimeUsageStatisticUiModel
import dev.yaaum.presentation.core.platform.mvi.state.content.MviContent

data class HealthMviContent(
    val data: List<ApplicationsUiModel>?,
    val health: GeneralTimeUsageStatisticUiModel?,
) : MviContent
