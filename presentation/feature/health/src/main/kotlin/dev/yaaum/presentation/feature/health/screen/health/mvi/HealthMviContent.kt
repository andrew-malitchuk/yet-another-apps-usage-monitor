package dev.yaaum.presentation.feature.health.screen.health.mvi

import dev.yaaum.presentation.core.platform.mvi.state.content.MviContent

data class HealthMviContent(
    val message: String,
) : MviContent
