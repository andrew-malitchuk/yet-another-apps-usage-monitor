package dev.yaaum.domain.configuration.model

import dev.yaaum.data.repository.configuration.model.ConfigurationRepoModel
import dev.yaaum.domain.core.model.BaseDomainModel

/**
 * Represent application configuration which can be modified by user
 */
data class ConfigurationDomainModel(
    val themeMode: String? = null,
) : BaseDomainModel

/**
 * `ConfigurationDomainModel` -> `ConfigurationRepoModel`
 */
fun ConfigurationDomainModel.toRepoModel(): ConfigurationRepoModel {
    return ConfigurationRepoModel(
        themeMode = this.themeMode,
    )
}

/**
 * `ConfigurationRepoModel` -> `ConfigurationDomainModel`
 */
fun ConfigurationRepoModel.toDomainModel(): ConfigurationDomainModel {
    return ConfigurationDomainModel(
        themeMode = this.themeMode,
    )
}
