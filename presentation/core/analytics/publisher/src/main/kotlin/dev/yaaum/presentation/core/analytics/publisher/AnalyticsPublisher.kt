package dev.yaaum.presentation.core.analytics.publisher

import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticModel
import dev.yaaum.presentation.core.analytics.subscriber.AnalyticsSubscriber

interface AnalyticsPublisher {
    fun subscribe(subscriber: AnalyticsSubscriber)
    fun unsubscribe(subscriber: AnalyticsSubscriber)
    fun notify(input: BaseAnalyticModel)
}