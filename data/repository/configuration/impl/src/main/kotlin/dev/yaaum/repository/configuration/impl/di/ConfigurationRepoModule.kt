package dev.yaaum.repository.configuration.impl.di

import dev.yaaum.data.repository.configuration.ConfigurationRepository
import dev.yaaum.repository.configuration.impl.ConfigurationRepositoryImpl
import org.koin.dsl.module

/**
 * `:data:repository:configuration:impl`
 */
val configurationRepoModule = module {
    single<ConfigurationRepository> {
        ConfigurationRepositoryImpl(
            configurationDataStoreSource = get(),
        )
    }
}
