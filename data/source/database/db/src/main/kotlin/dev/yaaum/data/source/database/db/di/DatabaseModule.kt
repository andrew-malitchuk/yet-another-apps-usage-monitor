package dev.yaaum.data.source.database.db.di

import androidx.room.Room
import dev.yaaum.data.source.database.db.YaaumDatabase
import dev.yaaum.data.source.database.db.YaaumDatabase.Companion.DB_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

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
}
