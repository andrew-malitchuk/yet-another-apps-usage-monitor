package dev.yaaum.data.source.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.yaaum.data.source.database.applications.dao.ApplicationsDatabaseDao
import dev.yaaum.data.source.database.applications.model.ApplicationsDatabaseModel
import dev.yaaum.data.source.database.db.YaaumDatabase.Companion.DB_VERSION

@Database(
    version = DB_VERSION,
    entities = [
        ApplicationsDatabaseModel::class,
    ],
)
abstract class YaaumDatabase : RoomDatabase() {
    abstract fun getApplicationsDatabaseDao(): ApplicationsDatabaseDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "YAAUM"
    }
}
