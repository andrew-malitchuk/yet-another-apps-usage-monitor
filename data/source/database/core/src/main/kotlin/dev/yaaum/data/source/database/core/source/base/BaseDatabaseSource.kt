package dev.yaaum.data.source.database.core.source.base

import dev.yaaum.data.source.database.core.model.base.BaseDatabaseModel
import kotlinx.coroutines.flow.Flow

/**
 * Base artifact for all database sources; provide all possible (hypothetically) CRUD operation.
 *
 * Main goal is to avoid boilerplate
 */
interface BaseDatabaseSource<T : BaseDatabaseModel> {
    suspend fun get(id: Int): T?
    suspend fun get(): List<T>
    suspend fun getFlow(): Flow<List<T>?>
    suspend fun insert(value: T): Int
    suspend fun insert(values: List<T>)
    suspend fun update(value: T)
    suspend fun update(values: List<T>)
    suspend fun delete(id: Int)
    suspend fun delete(ids: List<Int>)
    suspend fun deleteAll()
    suspend fun search(request: String)
}
