package dev.yaaum.domain.configuration.impl.di

import dev.yaaum.domain.configuration.GetCurrentConfigurationUseCase
import dev.yaaum.domain.configuration.SetOrUpdateConfigurationUseCase
import dev.yaaum.domain.configuration.impl.GetCurrentConfigurationUseCaseImpl
import dev.yaaum.domain.configuration.impl.SetOrUpdateConfigurationUseCaseImpl
import org.koin.dsl.module

/**
 * `:domain:configuration:impl`
 */
val configurationDomainModule = module {
    single<GetCurrentConfigurationUseCase> {
        GetCurrentConfigurationUseCaseImpl(
            configurationRepository = get(),
        )
    }
    single<SetOrUpdateConfigurationUseCase> {
        SetOrUpdateConfigurationUseCaseImpl(
            configurationRepository = get(),
        )
    }
}
