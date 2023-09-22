package dev.yaaum.data.source.datastore.configuration.impl.source

import dev.yaaum.data.source.datastore.configuration.impl.dao.ConfigurationDataStoreDao
import dev.yaaum.data.source.datastore.configuration.model.ConfigurationDataStoreModel
import dev.yaaum.data.source.datastore.configuration.source.ConfigurationDataStoreSource
import kotlinx.coroutines.flow.Flow

class ConfigurationDataStoreSourceImpl(
    private val configurationDataStoreDao: ConfigurationDataStoreDao,
) : ConfigurationDataStoreSource {

    override fun subscribeToData(): Flow<ConfigurationDataStoreModel> {
        return configurationDataStoreDao.subscribeToData()
    }

    override suspend fun updateData(value: ConfigurationDataStoreModel) {
        configurationDataStoreDao.updateData(value)
    }
}
