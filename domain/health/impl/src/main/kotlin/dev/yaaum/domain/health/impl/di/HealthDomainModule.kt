package dev.yaaum.domain.health.impl.di

import dev.yaaum.domain.health.GetGeneralTimeUsageStatisticUseCase
import dev.yaaum.domain.health.impl.GetGeneralTimeUsageStatisticUseCaseImpl
import org.koin.dsl.module

/**
 * `:domain:health:impl`
 */
val healthDomainModule = module {
    single<GetGeneralTimeUsageStatisticUseCase> {
        GetGeneralTimeUsageStatisticUseCaseImpl(
            getTotalUsageOfAllApplicationUseCase = get(),
            getTotalUsageOfChosenApplicationUseCase = get(),
            getTotalUsageOfUserApplicationsUseCase = get(),
        )
    }
}
