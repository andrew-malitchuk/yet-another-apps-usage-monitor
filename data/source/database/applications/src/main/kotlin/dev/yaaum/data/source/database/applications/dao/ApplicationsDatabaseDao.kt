package dev.yaaum.data.source.database.applications.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.yaaum.data.source.database.applications.Table
import dev.yaaum.data.source.database.applications.model.ApplicationsDatabaseModel

@Dao
interface ApplicationsDatabaseDao {

    @Query("SELECT * FROM ${Table.APPLICATIONS}")
    suspend fun get(): List<ApplicationsDatabaseModel>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(value: ApplicationsDatabaseModel): Long
}
