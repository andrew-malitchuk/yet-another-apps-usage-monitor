package dev.yaaum.data.source.datastore.configuration.impl.di

import android.content.Context
import dev.yaaum.data.source.datastore.configuration.impl.dao.ConfigurationDataStoreDao
import dev.yaaum.data.source.datastore.configuration.impl.source.ConfigurationDataStoreSourceImpl
import dev.yaaum.data.source.datastore.configuration.source.ConfigurationDataStoreSource
import org.koin.dsl.module

/**
 * `:data:source:datastore:configuration:impl`
 */
val configurationDataStoreDataModule = module {

    fun provideConfigurationDataStoreDao(context: Context): ConfigurationDataStoreDao {
        return ConfigurationDataStoreDao(context)
    }

    single<ConfigurationDataStoreSource> {
        ConfigurationDataStoreSourceImpl(
            get(),
        )
    }

    single {
        provideConfigurationDataStoreDao(get())
    }
}
