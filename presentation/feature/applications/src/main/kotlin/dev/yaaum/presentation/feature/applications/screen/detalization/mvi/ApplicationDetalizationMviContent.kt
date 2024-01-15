package dev.yaaum.presentation.feature.applications.screen.detalization.mvi

import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.models.DayUsageStatisticUiModel
import dev.yaaum.presentation.core.models.HealthStatusUiModel
import dev.yaaum.presentation.core.platform.mvi.state.content.MviContent

data class ApplicationDetalizationMviContent(
    val data: ApplicationsUiModel?,
    val packageName: String?,
    val weekUsageStatics: List<DayUsageStatisticUiModel>?,
    val health: HealthStatusUiModel?,
) : MviContent
