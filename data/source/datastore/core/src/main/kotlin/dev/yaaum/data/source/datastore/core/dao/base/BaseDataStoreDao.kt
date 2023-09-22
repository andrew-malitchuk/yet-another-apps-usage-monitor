package dev.yaaum.data.source.datastore.core.dao.base

import dev.yaaum.data.source.datastore.core.model.base.BaseDataStoreModel
import kotlinx.coroutines.flow.Flow

/**
 * Determinate base action with datastore
 */
interface BaseDataStoreDao<T : BaseDataStoreModel> {
    fun subscribeToData(): Flow<T>
    suspend fun updateData(value: T)
}
