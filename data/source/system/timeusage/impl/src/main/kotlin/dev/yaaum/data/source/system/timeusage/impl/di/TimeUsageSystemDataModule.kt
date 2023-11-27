package dev.yaaum.data.source.system.timeusage.impl.di

import dev.yaaum.data.source.system.timeusage.impl.source.TimeUsageDataSourceImpl
import dev.yaaum.data.source.system.timeusage.source.TimeUsageDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * `:data:system:timeusage:impl`
 */
val timeUsageSystemDataModule = module {
    single<TimeUsageDataSource> {
        TimeUsageDataSourceImpl(androidContext())
    }
}
