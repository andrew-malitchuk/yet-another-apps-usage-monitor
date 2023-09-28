package dev.yaaum.presentation.core.analytics.publisher

import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticModel
import dev.yaaum.presentation.core.analytics.subscriber.AnalyticsSubscriber

/**
 * Notify (a.k.a sent) subscriber (a.k.a. analytics provider) about income event
 */
interface AnalyticsPublisher {
    /**
     * Add [subscriber] implementation to set of the subscribers
     *
     * @param subscriber AnalyticsSubscriber implementation
     */
    fun subscribe(subscriber: AnalyticsSubscriber)

    /**
     * Remove [subscriber] from set of the subscribers
     *
     * @param subscriber AnalyticsSubscriber implementation
     */
    fun unsubscribe(subscriber: AnalyticsSubscriber)

    /**
     * Log some analytics event
     *
     * @param input
     */
    fun notify(input: BaseAnalyticModel)
}
