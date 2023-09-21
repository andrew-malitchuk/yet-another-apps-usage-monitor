package dev.yaaum.domain.configuration.model

import dev.yaaum.data.repository.configuration.model.ConfigurationRepoModel
import dev.yaaum.domain.core.model.BaseDomainModel

data class ConfigurationDomainModel(
    val themeMode: String? = null,
) : BaseDomainModel

fun ConfigurationDomainModel.toRepoModel(): ConfigurationRepoModel {
    return ConfigurationRepoModel(
        themeMode = this.themeMode,
    )
}

fun ConfigurationRepoModel.toDomainModel(): ConfigurationDomainModel {
    return ConfigurationDomainModel(
        themeMode = this.themeMode,
    )
}
