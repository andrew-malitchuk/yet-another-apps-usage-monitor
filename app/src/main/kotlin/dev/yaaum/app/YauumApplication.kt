package dev.yaaum.app

import android.app.Application
import dev.yaaum.data.source.database.applications.impl.di.applicationsDatabaseModule
import dev.yaaum.data.source.database.db.di.databaseModule
import dev.yaaum.data.source.datastore.configuration.impl.di.configurationDataStoreModule
import dev.yaaum.data.source.system.applications.impl.di.applicationsSystemModule
import dev.yaaum.data.source.system.timeusage.impl.di.timeUsageSystemModule
import dev.yaaum.domain.applications.impl.di.applicationsDomainModule
import dev.yaaum.domain.configuration.impl.di.configurationDomainModule
import dev.yaaum.domain.timeusage.impl.di.timeUsageDomainModule
import dev.yaaum.presentaion.feature.onboarding.di.onboardingFeatureModule
import dev.yaaum.presentation.core.analytics.logger.impl.di.analyticsLoggerModule
import dev.yaaum.presentation.core.analytics.publisher.impl.di.analyticsProviderModule
import dev.yaaum.presentation.core.analytics.subscriber.impl.local.di.localAnalyticsModule
import dev.yaaum.presentation.feature.applications.di.applicationsFeatureModule
import dev.yaaum.presentation.feature.host.navigation.navigationInit
import dev.yaaum.presentation.feature.main.di.mainFeatureModule
import dev.yaaum.repository.applications.impl.di.applicationsRepoModule
import dev.yaaum.repository.configuration.impl.di.configurationRepoModule
import dev.yaaum.repository.timeusage.impl.di.timeUsageRepoModule
import logcat.AndroidLogcatLogger
import logcat.LogPriority
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
        AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.VERBOSE)
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
                    mainFeatureModule,
                    onboardingFeatureModule,
                    applicationsFeatureModule,
                    analyticsLoggerModule,
                    analyticsProviderModule,
                    localAnalyticsModule,
                    applicationsSystemModule,
                    applicationsRepoModule,
                    applicationsDomainModule,
                    databaseModule,
                    applicationsDatabaseModule,
                ),
            )
        }
    }
}
