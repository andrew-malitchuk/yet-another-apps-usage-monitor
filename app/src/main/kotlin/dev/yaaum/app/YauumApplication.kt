package dev.yaaum.app

import android.app.Application
import dev.yaaum.data.source.system.timeusage.impl.di.timeUsageSystemModule
import dev.yaaum.data.source.system.timeusage.source.TimeUsageDataSource
import dev.yaaum.domain.timeusage.GetStatisticsAboutAllAppsUseCase
import dev.yaaum.domain.timeusage.impl.di.timeUsageDomainModule
import dev.yaaum.host.navigation.navigationInit
import dev.yaaum.repository.timeusage.impl.di.timeUsageRepoModule
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YauumApplication : Application() {

    val foo: TimeUsageDataSource by inject()

    val bar: GetStatisticsAboutAllAppsUseCase by inject()

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
                ),
            )
        }
    }
}
