package dev.yaaum.repository.configuration.impl

import dev.yaaum.data.repository.configuration.ConfigurationRepository
import dev.yaaum.data.repository.configuration.model.ConfigurationRepoModel
import dev.yaaum.data.repository.configuration.model.toDataStoreModel
import dev.yaaum.data.repository.configuration.model.toRepoModel
import dev.yaaum.data.source.datastore.configuration.source.ConfigurationDataStoreSource
import kotlinx.coroutines.flow.firstOrNull

class ConfigurationRepositoryImpl(
    private val configurationDataStoreSource: ConfigurationDataStoreSource,
) : ConfigurationRepository {

    override suspend fun getCurrentConfiguration(): ConfigurationRepoModel? {
        return configurationDataStoreSource.subscribeToData().firstOrNull()?.toRepoModel()
    }

    override suspend fun setOrUpdateConfiguration(value: ConfigurationRepoModel) {
        configurationDataStoreSource.updateData(value.toDataStoreModel())
    }
}
