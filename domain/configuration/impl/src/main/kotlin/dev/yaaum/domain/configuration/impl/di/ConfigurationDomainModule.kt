package dev.yaaum.domain.configuration.impl.di

import dev.yaaum.domain.configuration.GetCurrentConfigurationUseCase
import dev.yaaum.domain.configuration.IsOnboardingFinishedUseCase
import dev.yaaum.domain.configuration.SetOnboardingFinishedUseCase
import dev.yaaum.domain.configuration.SetOrUpdateConfigurationUseCase
import dev.yaaum.domain.configuration.impl.GetCurrentConfigurationUseCaseImpl
import dev.yaaum.domain.configuration.impl.IsOnboardingFinishedUseCaseImpl
import dev.yaaum.domain.configuration.impl.SetOnboardingFinishedUseCaseImpl
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
    single<IsOnboardingFinishedUseCase> {
        IsOnboardingFinishedUseCaseImpl(
            configurationRepository = get(),
        )
    }
    single<SetOnboardingFinishedUseCase> {
        SetOnboardingFinishedUseCaseImpl(
            configurationRepository = get(),
        )
    }
}
