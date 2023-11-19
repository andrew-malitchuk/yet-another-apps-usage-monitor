package dev.yaaum.data.source.database.applications.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.yaaum.data.source.database.applications.Table
import dev.yaaum.data.source.database.applications.model.ApplicationsDatabaseModel

/**
 * DAO for Application;
 *
 * Main goal is to store "chosen" applications.
 */
// TODO: test me
@Dao
interface ApplicationsDatabaseDao {

    /**
     * Get all entries from [Table.APPLICATIONS] table
     *
     * @return all available applications
     */
    @Query("SELECT * FROM ${Table.APPLICATIONS}")
    suspend fun get(): List<ApplicationsDatabaseModel>

    /**
     * Add new entry into [Table.APPLICATIONS] table
     *
     * __Conflict strategy:__ REPLACE
     *
     * @param value new entry to add
     *
     * @return new entry's id
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(value: ApplicationsDatabaseModel): Long

    /**
     * Delete entry from [Table.APPLICATIONS] table by it's `id` property value
     *
     * @param id entry's `id`
     */
    @Query("DELETE FROM ${Table.APPLICATIONS} WHERE id=:id")
    suspend fun delete(id: Int)

    /**
     * Delete entry from [Table.APPLICATIONS] table by it's `packageName` property value.
     *
     * @param packageName entry's `packageName`
     */
    // TODO: fix
    @Query("DELETE FROM ${Table.APPLICATIONS} WHERE applicationName=:packageName")
    suspend fun delete(packageName: String)
}
