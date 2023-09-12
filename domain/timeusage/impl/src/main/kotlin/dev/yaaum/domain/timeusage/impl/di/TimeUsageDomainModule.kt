package dev.yaaum.domain.timeusage.impl.di

import dev.yaaum.domain.timeusage.GetStatisticsAboutAllAppsUseCase
import dev.yaaum.domain.timeusage.impl.GetStatisticsAboutAllAppsUseCaseImpl
import org.koin.dsl.module

/**
 * `:domain:timeusage:impl`
 */
val timeUsageDomainModule = module {
    single<GetStatisticsAboutAllAppsUseCase> {
        GetStatisticsAboutAllAppsUseCaseImpl(
            timeUsageRepository = get(),
        )
    }
}
