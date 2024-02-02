package dev.yaaum.domain.health.impl.di

import dev.yaaum.domain.health.GetGeneralTimeUsageStatisticUseCase
import dev.yaaum.domain.health.GetHealthStatusForApplicationUseCase
import dev.yaaum.domain.health.GetHealthStatusUseCase
import dev.yaaum.domain.health.GetRateUseCase
import dev.yaaum.domain.health.impl.GetGeneralTimeUsageStatisticUseCaseImpl
import dev.yaaum.domain.health.impl.GetHealthStatusForApplicationUseCaseImpl
import dev.yaaum.domain.health.impl.GetHealthStatusUseCaseImpl
import dev.yaaum.domain.health.impl.GetRateUseCaseImpl
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
    single<GetHealthStatusUseCase> {
        GetHealthStatusUseCaseImpl(
            getGeneralTimeUsageStatisticUseCase = get(),
        )
    }
    single<GetHealthStatusForApplicationUseCase> {
        GetHealthStatusForApplicationUseCaseImpl(
            getTotalUsageOfUserApplicationsUseCase = get(),
            getApplicationUsageUseCase = get(),
        )
    }
    single<GetRateUseCase> {
        GetRateUseCaseImpl(
            getTotalUsageOfChosenApplicationUseCase = get(),
        )
    }
}
