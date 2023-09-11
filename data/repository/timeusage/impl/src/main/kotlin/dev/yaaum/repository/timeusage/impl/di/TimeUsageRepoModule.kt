package dev.yaaum.repository.timeusage.impl.di

import dev.yaaum.data.repository.timeusage.TimeUsageRepository
import dev.yaaum.repository.timeusage.impl.TimeUsageRepositoryImpl
import org.koin.dsl.module

/**
 * `:data:repository:timeusage:impl`
 */
val timeUsageRepoModule = module {
    single<TimeUsageRepository> {
        TimeUsageRepositoryImpl(
            timeUsageDataSource = get(),
        )
    }
}
