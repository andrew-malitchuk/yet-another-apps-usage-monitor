package dev.yaaum.data.source.database.applications.impl.di

import dev.yaaum.data.source.database.applications.impl.source.ApplicationsDatabaseSourceImpl
import dev.yaaum.data.source.database.applications.source.ApplicationsDatabaseSource
import org.koin.dsl.module

val applicationsDatabaseModule = module {
    single<ApplicationsDatabaseSource> {
        ApplicationsDatabaseSourceImpl(
            applicationsDatabaseDao = get(),
        )
    }
}
