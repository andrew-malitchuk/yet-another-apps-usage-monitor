package dev.yaaum.app

import android.app.Application
import android.util.Log
import arrow.core.raise.fold
import dev.yaaum.data.source.datastore.configuration.impl.di.configurationDataStoreModule
import dev.yaaum.data.source.system.timeusage.impl.di.timeUsageSystemModule
import dev.yaaum.data.source.system.timeusage.source.TimeUsageDataSource
import dev.yaaum.domain.configuration.GetCurrentConfigurationUseCase
import dev.yaaum.domain.configuration.SetOrUpdateConfigurationUseCase
import dev.yaaum.domain.configuration.impl.di.configurationDomainModule
import dev.yaaum.domain.configuration.model.ConfigurationDomainModel
import dev.yaaum.domain.timeusage.GetStatisticsAboutAllAppsUseCase
import dev.yaaum.domain.timeusage.impl.di.timeUsageDomainModule
import dev.yaaum.presentation.feature.host.navigation.navigationInit
import dev.yaaum.repository.configuration.impl.di.configurationRepoModule
import dev.yaaum.repository.timeusage.impl.di.timeUsageRepoModule
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YauumApplication : Application() {

    val foo: TimeUsageDataSource by inject()

    val bar: GetStatisticsAboutAllAppsUseCase by inject()
    val set: SetOrUpdateConfigurationUseCase by inject()
    val get: GetCurrentConfigurationUseCase by inject()

    override fun onCreate() {
        super.onCreate()
        navigationInit()
        diInit()

        GlobalScope.launch {
            bar().fold(
                {
                },
                { result ->
                    result.toString()
                },
            )

            fold(
                {
                    set(ConfigurationDomainModel("foo"))
                },
                {
                },
                {
                },
            )

            get().fold(
                {
                    Log.d("foo", it.toString())
                },
                {
                    Log.d("foo", it.toString())
                },
            )
        }
    }

    private fun diInit() {
        startKoin {
            androidContext(this@YauumApplication)
            modules(
                listOf(
                    // TODO: add in separated modules like `domainModule`, `dataModule` etc
                    timeUsageDomainModule,
                    timeUsageSystemModule,
                    timeUsageRepoModule,
                    configurationRepoModule,
                    configurationDataStoreModule,
                    configurationDomainModule,
                ),
            )
        }
    }
}
