package dev.yaaum.data.source.database.applications.impl.source

import dev.yaaum.data.source.database.applications.dao.ApplicationsDatabaseDao
import dev.yaaum.data.source.database.applications.model.ApplicationsDatabaseModel
import dev.yaaum.data.source.database.applications.source.ApplicationsDatabaseSource
import kotlinx.coroutines.flow.Flow

// TODO: implement me
class ApplicationsDatabaseSourceImpl(
    private val applicationsDatabaseDao: ApplicationsDatabaseDao,
) : ApplicationsDatabaseSource {

    override suspend fun get(id: Int): ApplicationsDatabaseModel? {
        TODO("Not yet implemented")
    }

    override suspend fun get(): List<ApplicationsDatabaseModel> {
        return applicationsDatabaseDao.get()
    }

    override suspend fun getFlow(): Flow<List<ApplicationsDatabaseModel>?> {
        TODO("Not yet implemented")
    }

    override suspend fun insert(value: ApplicationsDatabaseModel): Int {
        return applicationsDatabaseDao.insert(value).toInt()
    }

    override suspend fun insert(values: List<ApplicationsDatabaseModel>) {
        TODO("Not yet implemented")
    }

    override suspend fun update(value: ApplicationsDatabaseModel) {
        TODO("Not yet implemented")
    }

    override suspend fun update(values: List<ApplicationsDatabaseModel>) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int) {
        applicationsDatabaseDao.delete(id)
    }

    override suspend fun delete(packageName: String) {
        applicationsDatabaseDao.delete(packageName)
    }

    override suspend fun delete(ids: List<Int>) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() {
        TODO("Not yet implemented")
    }

    override suspend fun search(request: String) {
        TODO("Not yet implemented")
    }
}
