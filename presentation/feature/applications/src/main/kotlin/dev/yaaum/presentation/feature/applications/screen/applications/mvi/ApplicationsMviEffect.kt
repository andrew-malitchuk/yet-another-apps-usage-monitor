package dev.yaaum.presentation.feature.applications.screen.applications.mvi

import dev.yaaum.presentation.core.platform.mvi.effect.MviEffect

sealed class ApplicationsMviEffect : MviEffect {
    /**
     * Specify transition from applications list to application details
     */
    data object GoToDetailsScreenMviEffect : ApplicationsMviEffect()
}
