package dev.yaaum.presentation.core.analytics.publisher.impl

import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticEvent
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticModel
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticProperty
import dev.yaaum.presentation.core.analytics.publisher.AnalyticsPublisher
import dev.yaaum.presentation.core.analytics.subscriber.AnalyticsSubscriber

class AnalyticsPublisherImpl : AnalyticsPublisher {

    private var subscribers: Set<AnalyticsSubscriber> = emptySet()

    override fun subscribe(subscriber: AnalyticsSubscriber) {
        (subscribers as? MutableSet)?.add(subscriber)
    }

    override fun unsubscribe(subscriber: AnalyticsSubscriber) {
        (subscribers as? MutableSet)?.remove(subscriber)
    }

    override fun notify(input: BaseAnalyticModel) {
        subscribers.forEach { subscriber ->
            when (input) {
                is BaseAnalyticProperty -> {
                    subscriber.setProperty(input)
                }

                is BaseAnalyticEvent -> {
                    subscriber.logEvent(input)
                }
            }
        }
    }
}