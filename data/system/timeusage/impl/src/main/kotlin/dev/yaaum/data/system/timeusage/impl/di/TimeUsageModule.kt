package dev.yaaum.data.system.timeusage.impl.di

import dev.yaaum.data.system.timeusage.impl.source.TimeUsageDataSourceImpl
import dev.yaaum.data.system.timeusage.source.TimeUsageDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val timeUsageModule = module {
    single<TimeUsageDataSource> {
        TimeUsageDataSourceImpl(androidContext())
    }
}
