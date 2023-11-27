package dev.yaaum.app.di

import dev.yaaum.data.source.database.applications.impl.di.applicationsDatabaseDataModule
import dev.yaaum.data.source.database.db.di.databaseDataModule
import dev.yaaum.data.source.datastore.configuration.impl.di.configurationDataStoreDataModule
import dev.yaaum.data.source.system.applications.impl.di.applicationsSystemDataModule
import dev.yaaum.data.source.system.timeusage.impl.di.timeUsageSystemDataModule
import org.koin.dsl.module

/**
 * All di-modules from data layer
 */
val dataDiModule = module {
    includes(
        applicationsDatabaseDataModule,
        databaseDataModule,
        configurationDataStoreDataModule,
        applicationsSystemDataModule,
        timeUsageSystemDataModule,
    )
}
