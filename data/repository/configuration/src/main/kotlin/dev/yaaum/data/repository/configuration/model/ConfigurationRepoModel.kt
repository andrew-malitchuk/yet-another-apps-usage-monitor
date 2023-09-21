package dev.yaaum.data.repository.configuration.model

import dev.yaaum.data.repository.core.model.base.BaseRepoModel
import dev.yaaum.data.source.datastore.configuration.model.ConfigurationDataStoreModel

data class ConfigurationRepoModel(
    val themeMode: String? = null,
) : BaseRepoModel

fun ConfigurationRepoModel.toDataStoreModel(): ConfigurationDataStoreModel {
    return ConfigurationDataStoreModel(
        themeMode = this.themeMode,
    )
}

fun ConfigurationDataStoreModel.toRepoModel(): ConfigurationRepoModel {
    return ConfigurationRepoModel(
        themeMode = this.themeMode,
    )
}
