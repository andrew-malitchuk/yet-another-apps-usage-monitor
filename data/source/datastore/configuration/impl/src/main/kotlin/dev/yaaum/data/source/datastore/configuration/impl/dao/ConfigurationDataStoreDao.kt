package dev.yaaum.data.source.datastore.configuration.impl.dao

import android.content.Context
import androidx.datastore.dataStore
import dev.yaaum.data.source.datastore.configuration.impl.ConfigurationDataStore
import dev.yaaum.data.source.datastore.configuration.impl.serializer.ConfigurationSerializer
import dev.yaaum.data.source.datastore.configuration.model.ConfigurationDataStoreModel
import dev.yaaum.data.source.datastore.core.dao.base.BaseDataStoreDao
import kotlinx.coroutines.flow.Flow

class ConfigurationDataStoreDao(
    private val context: Context,
) : BaseDataStoreDao<ConfigurationDataStoreModel> {

    /**
     * DAO for configuration
     */
    private val Context.datastore by dataStore(
        ConfigurationDataStore.FILENAME,
        ConfigurationSerializer,
    )

    override fun subscribeToData(): Flow<ConfigurationDataStoreModel> {
        return context.datastore.data
    }

    override suspend fun updateData(value: ConfigurationDataStoreModel) {
        context.datastore.updateData { configuration ->
            configuration.copy(
                themeMode = value.themeMode,
            )
        }
    }
}
