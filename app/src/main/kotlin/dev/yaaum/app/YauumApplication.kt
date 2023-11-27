package dev.yaaum.app

import android.app.Application
import dev.yaaum.app.di.analyticsDiModule
import dev.yaaum.app.di.dataDiModule
import dev.yaaum.app.di.domainDiModule
import dev.yaaum.app.di.featureDiModule
import dev.yaaum.app.di.repositoryDiModule
import dev.yaaum.presentation.feature.host.navigation.navigationInit
import io.getstream.log.android.AndroidStreamLogger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YauumApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        navigationInit()
        loggerInit()
        diInit()
    }

    private fun loggerInit() {
        AndroidStreamLogger.installOnDebuggableApp(this)
    }

    private fun diInit() {
        startKoin {
            androidContext(this@YauumApplication)
            modules(
                listOf(
                    domainDiModule,
                    dataDiModule,
                    repositoryDiModule,
                    featureDiModule,
                    analyticsDiModule,
                ),
            )
        }
    }
}
