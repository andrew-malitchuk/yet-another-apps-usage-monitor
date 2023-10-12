package dev.yaaum.repository.applications.impl.di

import dev.yaaum.data.repository.applications.ApplicationsRepository
import dev.yaaum.repository.applications.impl.ApplicationsRepositoryImpl
import org.koin.dsl.module

/**
 * `:data:repository:applications:impl`
 */
val applicationsRepoModule = module {
    single<ApplicationsRepository> {
        ApplicationsRepositoryImpl(
            applicationsDataSource = get(),
        )
    }
}
