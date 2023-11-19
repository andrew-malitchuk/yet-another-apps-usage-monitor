package dev.yaaum.data.source.database.db.di

import androidx.room.Room
import dev.yaaum.data.source.database.db.DB_NAME
import dev.yaaum.data.source.database.db.YaaumDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * `:data:source:database:db`
 */
val databaseModule = module {

    single {
        Room
            .databaseBuilder(
                androidContext(),
                YaaumDatabase::class.java,
                DB_NAME,
            )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    single { _ ->
        (get() as YaaumDatabase).getApplicationsDatabaseDao()
    }
}
