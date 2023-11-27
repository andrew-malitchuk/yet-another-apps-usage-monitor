package dev.yaaum.app.di

import dev.yaaum.domain.applications.impl.di.applicationsDomainModule
import dev.yaaum.domain.configuration.impl.di.configurationDomainModule
import dev.yaaum.domain.timeusage.impl.di.timeUsageDomainModule
import org.koin.dsl.module

/**
 * All di-modules from domain layer
 */
val domainDiModule = module {
    includes(
        timeUsageDomainModule,
        configurationDomainModule,
        applicationsDomainModule,
    )
}
