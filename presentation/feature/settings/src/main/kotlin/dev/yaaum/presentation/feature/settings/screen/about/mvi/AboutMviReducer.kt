package dev.yaaum.presentation.feature.settings.screen.about.mvi

import dev.yaaum.presentation.core.platform.mvi.MviReducer

class AboutMviReducer(initial: AboutMviState) :
    MviReducer<AboutMviState, AboutMviEvent>(initial) {
    override fun reduce(oldState: AboutMviState, event: AboutMviEvent) = Unit
}
