package dev.yaaum.data.repository.configuration.model

import dev.yaaum.data.repository.core.model.base.BaseRepoModel
import dev.yaaum.data.source.datastore.configuration.model.ConfigurationDataStoreModel

/**
 * Represent application configuration which can be modified by user
 */
data class ConfigurationRepoModel(
    val themeMode: String? = null,
    val isOnboardingFinished: Boolean?,
) : BaseRepoModel

/**
 * `ConfigurationRepoModel` -> `ConfigurationDataStoreModel`
 */
fun ConfigurationRepoModel.toDataStoreModel(): ConfigurationDataStoreModel {
    return ConfigurationDataStoreModel(
        themeMode = this.themeMode,
        isOnboardingFinished = this.isOnboardingFinished,
    )
}

/**
 * `ConfigurationDataStoreModel` -> `ConfigurationRepoModel`
 */
fun ConfigurationDataStoreModel.toRepoModel(): ConfigurationRepoModel {
    return ConfigurationRepoModel(
        themeMode = this.themeMode,
        isOnboardingFinished = this.isOnboardingFinished,
    )
}
