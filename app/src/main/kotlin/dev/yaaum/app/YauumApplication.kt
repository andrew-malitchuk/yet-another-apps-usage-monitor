package dev.yaaum.app

import android.app.Application
import dev.yaaum.data.source.datastore.configuration.impl.di.configurationDataStoreModule
import dev.yaaum.data.source.system.timeusage.impl.di.timeUsageSystemModule
import dev.yaaum.domain.configuration.impl.di.configurationDomainModule
import dev.yaaum.domain.timeusage.impl.di.timeUsageDomainModule
import dev.yaaum.presentaion.feature.onboarding.di.onboardingFeatureModule
import dev.yaaum.presentation.feature.host.navigation.navigationInit
import dev.yaaum.presentation.feature.main.di.mainFeatureModule
import dev.yaaum.repository.configuration.impl.di.configurationRepoModule
import dev.yaaum.repository.timeusage.impl.di.timeUsageRepoModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YauumApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        navigationInit()
        diInit()
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
//                    analyticsLoggerModule,
//                    analyticsProviderModule,
//                    localAnalyticsModule
                ),
            )
        }
    }
}
