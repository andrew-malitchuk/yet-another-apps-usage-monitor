package dev.yaaum.app.di

import dev.yaaum.repository.applications.impl.di.applicationsRepoModule
import dev.yaaum.repository.configuration.impl.di.configurationRepoModule
import dev.yaaum.repository.timeusage.impl.di.timeUsageRepoModule
import org.koin.dsl.module

/**
 * All di-modules from repo layer
 */
val repositoryDiModule = module {
    includes(
        applicationsRepoModule,
        configurationRepoModule,
        timeUsageRepoModule,
    )
}
