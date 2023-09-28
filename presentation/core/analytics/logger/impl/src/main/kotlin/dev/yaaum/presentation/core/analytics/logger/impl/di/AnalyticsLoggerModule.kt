package dev.yaaum.presentation.core.analytics.logger.impl.di

import dev.yaaum.presentation.core.analytics.logger.AnalyticsLogger
import dev.yaaum.presentation.core.analytics.logger.impl.AnalyticsLoggerImpl
import dev.yaaum.presentation.core.analytics.publisher.AnalyticsPublisher
import org.koin.core.qualifier.named
import org.koin.dsl.module


/**
 * `:presentation:core:analytics:logger`
 */
val analyticsLoggerModule = module {
    single<AnalyticsLogger> {
        AnalyticsLoggerImpl(
            publisher = get(),
            get(named("local-analytics"))
        )
    }
}
