package dev.yaaum.presentation.core.analytics.publisher.impl.di

import dev.yaaum.presentation.core.analytics.publisher.AnalyticsPublisher
import dev.yaaum.presentation.core.analytics.publisher.impl.AnalyticsPublisherImpl
import org.koin.dsl.module

/**
 * `:presentation:core:analytics:publisher`
 */
val analyticsProviderModule = module {
    single<AnalyticsPublisher> {
        AnalyticsPublisherImpl()
    }
}
