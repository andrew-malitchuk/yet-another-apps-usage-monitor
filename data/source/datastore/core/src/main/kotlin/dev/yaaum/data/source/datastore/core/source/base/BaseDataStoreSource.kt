package dev.yaaum.data.source.datastore.core.source.base

import dev.yaaum.data.source.datastore.core.model.base.BaseDataStoreModel
import kotlinx.coroutines.flow.Flow

interface BaseDataStoreSource<T : BaseDataStoreModel> {
    fun subscribeToData(): Flow<T>
    suspend fun updateData(value: T)
}
