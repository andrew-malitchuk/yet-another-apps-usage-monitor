package dev.yaaum.app

import android.app.Application
import arrow.core.raise.fold
import dev.yaaum.data.system.timeusage.impl.di.timeUsageModule
import dev.yaaum.data.system.timeusage.source.TimeUsageDataSource
import dev.yaaum.host.navigation.navigationInit
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YauumApplication : Application() {

    val foo: TimeUsageDataSource by inject()

    override fun onCreate() {
        super.onCreate()
        navigationInit()
        startKoin {
            androidContext(this@YauumApplication)
            modules(
                listOf(
                    timeUsageModule,
                ),
            )
        }
        GlobalScope.launch {
            fold({
                foo.getApplicationsUsage()
            }, { error ->
            }, { result ->
                result.toString()
            })
        }
    }
}
