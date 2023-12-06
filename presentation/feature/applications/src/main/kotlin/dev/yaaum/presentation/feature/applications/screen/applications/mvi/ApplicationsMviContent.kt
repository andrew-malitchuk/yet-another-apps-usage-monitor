package dev.yaaum.presentation.feature.applications.screen.applications.mvi

import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.platform.mvi.state.content.MviContent

data class ApplicationsMviContent(
    val data: List<ApplicationsUiModel>,
) : MviContent
