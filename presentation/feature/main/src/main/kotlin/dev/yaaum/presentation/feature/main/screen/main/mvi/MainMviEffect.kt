package dev.yaaum.presentation.feature.main.screen.main.mvi

import dev.yaaum.presentation.core.platform.mvi.effect.MviEffect

sealed class MainMviEffect : MviEffect {
    /**
     * Specify transition from applications list to application details
     */
    data object GoToDetailsScreenMviEffect : MainMviEffect()
}
