package dev.yaaum.presentation.feature.main.screen.main.mvi

import dev.yaaum.presentation.core.models.TimeUsageUiModel
import dev.yaaum.presentation.core.platform.mvi.state.content.MviContent

data class MainMviContent(
    val topUsageApps: List<TimeUsageUiModel>?,
) : MviContent
