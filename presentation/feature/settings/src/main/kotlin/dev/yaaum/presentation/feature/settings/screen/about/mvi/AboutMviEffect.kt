package dev.yaaum.presentation.feature.settings.screen.about.mvi

import dev.yaaum.presentation.core.platform.mvi.effect.MviEffect

sealed class AboutMviEffect : MviEffect {
    /**
     * Specify transition from about screen to github web page
     */
    data object GoToGithubMviEffect : AboutMviEffect()

    /**
     * Specify transition from about screen to demo page
     */
    data object GoToDemoMviEffect : AboutMviEffect()
}
