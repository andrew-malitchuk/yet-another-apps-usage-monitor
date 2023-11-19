package dev.yaaum.data.source.database.applications.source

import dev.yaaum.data.source.database.applications.model.ApplicationsDatabaseModel
import dev.yaaum.data.source.database.core.source.base.BaseDatabaseSource

interface ApplicationsDatabaseSource : BaseDatabaseSource<ApplicationsDatabaseModel> {
    suspend fun delete(packageName: String)
}
