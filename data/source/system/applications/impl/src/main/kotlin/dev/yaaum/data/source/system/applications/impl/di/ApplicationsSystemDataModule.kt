package dev.yaaum.data.source.system.applications.impl.di

import dev.yaaum.data.source.system.applications.impl.source.ApplicationsDataSourceImpl
import dev.yaaum.data.source.system.applications.source.ApplicationsDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * `:data:system:applications:impl`
 */
val applicationsSystemDataModule = module {
    single<ApplicationsDataSource> {
        ApplicationsDataSourceImpl(androidContext())
    }
}
