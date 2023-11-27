package dev.yaaum.app.di

import dev.yaaum.presentation.core.analytics.logger.impl.di.analyticsLoggerModule
import dev.yaaum.presentation.core.analytics.publisher.impl.di.analyticsProviderModule
import dev.yaaum.presentation.core.analytics.subscriber.impl.local.di.localAnalyticsModule
import org.koin.dsl.module

/**
 * All di-modules from analytics
 */
val analyticsDiModule = module {
    includes(
        analyticsLoggerModule,
        analyticsProviderModule,
        localAnalyticsModule,
    )
}
