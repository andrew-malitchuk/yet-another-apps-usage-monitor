package dev.yaaum.presentation.feature.health.screen.health.mvi

import dev.yaaum.presentation.core.platform.mvi.effect.MviEffect

sealed class HealthMviEffect : MviEffect {
    data class OpenApplicationDetalizationMviEffect(val packageName: String) : HealthMviEffect()
}
