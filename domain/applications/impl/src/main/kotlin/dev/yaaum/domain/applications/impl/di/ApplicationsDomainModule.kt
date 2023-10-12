package dev.yaaum.domain.applications.impl.di

import dev.yaaum.domain.applications.GetAllAppsUseCase
import dev.yaaum.domain.applications.impl.GetAllAppsUseCaseImpl
import org.koin.dsl.module

/**
 * `:domain:applications:impl`
 */
val applicationsDomainModule = module {
    single<GetAllAppsUseCase> {
        GetAllAppsUseCaseImpl(
            applicationsRepository = get(),
        )
    }
}
