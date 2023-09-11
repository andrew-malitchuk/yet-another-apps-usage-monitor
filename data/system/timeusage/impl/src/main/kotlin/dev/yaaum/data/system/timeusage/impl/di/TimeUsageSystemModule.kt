package dev.yaaum.data.system.timeusage.impl.di

import dev.yaaum.data.system.timeusage.impl.source.TimeUsageDataSourceImpl
import dev.yaaum.data.system.timeusage.source.TimeUsageDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * `:data:system:timeusage:impl`
 */
val timeUsageSystemModule = module {
    single<TimeUsageDataSource> {
        TimeUsageDataSourceImpl(androidContext())
    }
}
