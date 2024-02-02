package dev.yaaum.domain.timeusage.impl.di

import dev.yaaum.domain.timeusage.GetApplicationUsageUseCase
import dev.yaaum.domain.timeusage.GetStatisticsAboutAllAppsUseCase
import dev.yaaum.domain.timeusage.GetTopAppsWithHighestUsageUseCase
import dev.yaaum.domain.timeusage.GetTotalUsageOfAllApplicationUseCase
import dev.yaaum.domain.timeusage.GetTotalUsageOfChosenApplicationUseCase
import dev.yaaum.domain.timeusage.GetTotalUsageOfUserApplicationsUseCase
import dev.yaaum.domain.timeusage.GetWeekStatisticUseCase
import dev.yaaum.domain.timeusage.impl.GetApplicationUsageUseCaseImpl
import dev.yaaum.domain.timeusage.impl.GetStatisticsAboutAllAppsUseCaseImpl
import dev.yaaum.domain.timeusage.impl.GetTopAppsWithHighestUsageUseCaseImpl
import dev.yaaum.domain.timeusage.impl.GetTotalUsageOfAllApplicationUseCaseImpl
import dev.yaaum.domain.timeusage.impl.GetTotalUsageOfChosenApplicationUseCaseImpl
import dev.yaaum.domain.timeusage.impl.GetTotalUsageOfUserApplicationsUseCaseImpl
import dev.yaaum.domain.timeusage.impl.GetWeekStatisticUseCaseImpl
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
    single<GetTotalUsageOfAllApplicationUseCase> {
        GetTotalUsageOfAllApplicationUseCaseImpl(
            timeUsageRepository = get(),
        )
    }
    single<GetTotalUsageOfUserApplicationsUseCase> {
        GetTotalUsageOfUserApplicationsUseCaseImpl(
            timeUsageRepository = get(),
            applicationsRepository = get(),
        )
    }
    single<GetTotalUsageOfChosenApplicationUseCase> {
        GetTotalUsageOfChosenApplicationUseCaseImpl(
            timeUsageRepository = get(),
            applicationsRepository = get(),
        )
    }
    single<GetWeekStatisticUseCase> {
        GetWeekStatisticUseCaseImpl(
            timeUsageRepository = get(),
        )
    }
    single<GetApplicationUsageUseCase> {
        GetApplicationUsageUseCaseImpl(
            timeUsageRepository = get(),
        )
    }
}
