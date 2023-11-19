package dev.yaaum.domain.timeusage.impl.di

import dev.yaaum.domain.timeusage.GetStatisticsAboutAllAppsUseCase
import dev.yaaum.domain.timeusage.GetTopAppsWithHighestUsageUseCase
import dev.yaaum.domain.timeusage.impl.GetStatisticsAboutAllAppsUseCaseImpl
import dev.yaaum.domain.timeusage.impl.GetTopAppsWithHighestUsageUseCaseImpl
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
    single<GetTopAppsWithHighestUsageUseCase> {
        GetTopAppsWithHighestUsageUseCaseImpl(
            timeUsageRepository = get(),
        )
    }
}
