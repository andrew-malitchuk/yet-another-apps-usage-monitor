package dev.yaaum.data.source.database.db.di

import androidx.room.Room
import dev.yaaum.data.source.database.db.DB_NAME
import dev.yaaum.data.source.database.db.YaaumDatabase
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

    single { params ->

        (get() as YaaumDatabase).getApplicationsDatabaseDao()

//        (params.get() as YaaumDatabase).getApplicationsDatabaseDao()
    }
}
