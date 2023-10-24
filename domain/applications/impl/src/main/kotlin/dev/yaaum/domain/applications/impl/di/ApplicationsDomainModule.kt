package dev.yaaum.domain.applications.impl.di

import dev.yaaum.domain.applications.AddAppToChosenUseCase
import dev.yaaum.domain.applications.FilterAllAppsUseCase
import dev.yaaum.domain.applications.GetAllAppsUseCase
import dev.yaaum.domain.applications.GetApplicationWithChosenCase
import dev.yaaum.domain.applications.GetUserAppsUseCase
import dev.yaaum.domain.applications.RemoveAppFromChosenUseCase
import dev.yaaum.domain.applications.impl.AddAppToChosenUseCaseImpl
import dev.yaaum.domain.applications.impl.FilterAllAppsUseCaseImpl
import dev.yaaum.domain.applications.impl.GetAllAppsUseCaseImpl
import dev.yaaum.domain.applications.impl.GetApplicationWithChosenCaseImpl
import dev.yaaum.domain.applications.impl.GetUserAppsUseCaseImpl
import dev.yaaum.domain.applications.impl.RemoveAppFromChosenUseCaseImpl
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
    single<FilterAllAppsUseCase> {
        FilterAllAppsUseCaseImpl(
            applicationsRepository = get(),
        )
    }
    single<RemoveAppFromChosenUseCase> {
        RemoveAppFromChosenUseCaseImpl(
            applicationsRepository = get(),
        )
    }
    single<AddAppToChosenUseCase> {
        AddAppToChosenUseCaseImpl(
            applicationsRepository = get(),
        )
    }
    single<GetApplicationWithChosenCase> {
        GetApplicationWithChosenCaseImpl(
            applicationsRepository = get(),
        )
    }
}
