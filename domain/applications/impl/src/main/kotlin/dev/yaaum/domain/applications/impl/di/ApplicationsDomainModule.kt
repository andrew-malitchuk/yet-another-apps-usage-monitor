package dev.yaaum.domain.applications.impl.di

import dev.yaaum.domain.applications.GetAllAppsUseCase
import dev.yaaum.domain.applications.GetUserAppsUseCase
import dev.yaaum.domain.applications.impl.GetAllAppsUseCaseImpl
import dev.yaaum.domain.applications.impl.GetUserAppsUseCaseImpl
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
    single<GetUserAppsUseCase> {
        GetUserAppsUseCaseImpl(
            applicationsRepository = get(),
        )
    }
}
