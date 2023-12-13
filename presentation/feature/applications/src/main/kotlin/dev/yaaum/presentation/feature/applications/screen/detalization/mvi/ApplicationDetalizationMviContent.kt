package dev.yaaum.presentation.feature.applications.screen.detalization.mvi

import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.platform.mvi.state.content.MviContent

data class ApplicationDetalizationMviContent(
    val data: ApplicationsUiModel?,
    val packageName: String?,
) : MviContent
