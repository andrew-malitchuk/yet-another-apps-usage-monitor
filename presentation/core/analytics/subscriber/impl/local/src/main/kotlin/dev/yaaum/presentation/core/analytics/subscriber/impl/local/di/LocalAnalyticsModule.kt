package dev.yaaum.presentation.core.analytics.subscriber.impl.local.di

import dev.yaaum.presentation.core.analytics.subscriber.AnalyticsSubscriber
import dev.yaaum.presentation.core.analytics.subscriber.impl.local.LocalAnalyticsSubscriber
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * `:presentation:core:analytics:subscriber:impl:local`
 */
val localAnalyticsModule = module {
    single<AnalyticsSubscriber>(named("local-analytics")) {
        LocalAnalyticsSubscriber()
    }
}
