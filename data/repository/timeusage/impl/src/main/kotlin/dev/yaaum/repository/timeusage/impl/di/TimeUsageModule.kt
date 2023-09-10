package dev.yaaum.repository.timeusage.impl.di

import dev.yaaum.data.system.timeusage.source.TimeUsageDataSource
import dev.yaaum.repository.timeusage.impl.source.TimeUsageDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val timeUsageModule = module {
    single<TimeUsageDataSource> {
        TimeUsageDataSourceImpl(androidContext())
    }
}
