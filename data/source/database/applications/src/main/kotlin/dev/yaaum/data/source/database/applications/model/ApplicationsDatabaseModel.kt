package dev.yaaum.data.source.database.applications.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import dev.yaaum.data.source.database.applications.Table
import dev.yaaum.data.source.database.core.model.base.BaseDatabaseModel

/**
 * Represent information about application
 */
@Entity(
    tableName = Table.APPLICATIONS,
    indices = [
        Index(
            value = ["packageName", "applicationName"],
            unique = true,
        ),
    ],
)
data class ApplicationsDatabaseModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "uuid")
    val uuid: Int,
    @ColumnInfo(name = "packageName")
    val packageName: String,
    @ColumnInfo(name = "applicationName")
    val applicationName: String,
) : BaseDatabaseModel
