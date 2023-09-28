package dev.yaaum.presentation.core.models

import dev.yaaum.domain.configuration.model.ConfigurationDomainModel
import dev.yaaum.presentation.core.models.base.BaseUiModel

/**
 * Represent application configuration which can be modified by user
 */
data class ConfigurationUiModel(
    val themeMode: ThemeUiModel? = ThemeUiModel.AUTO,
    val isOnboardingFinished: Boolean?,
) : BaseUiModel

/**
 * `ConfigurationUiModel` -> `ConfigurationDomainModel`
 */
@Suppress("unused")
fun ConfigurationUiModel.toDomainModel(): ConfigurationDomainModel {
    return ConfigurationDomainModel(
        themeMode = this.themeMode?.theme,
        isOnboardingFinished = this.isOnboardingFinished,
    )
}

/**
 * `ConfigurationDomainModel` -> `ConfigurationUiModel`
 */
fun ConfigurationDomainModel.toUiModel(): ConfigurationUiModel {
    return ConfigurationUiModel(
        themeMode = this.themeMode?.let {
            ThemeUiModel.values().firstOrNull { it.theme == this.themeMode }
        },
        isOnboardingFinished = this.isOnboardingFinished,
    )
}
