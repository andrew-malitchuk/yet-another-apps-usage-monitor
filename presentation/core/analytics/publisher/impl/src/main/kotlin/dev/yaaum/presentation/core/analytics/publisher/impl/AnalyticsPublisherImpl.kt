package dev.yaaum.presentation.core.analytics.publisher.impl

import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticEvent
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticModel
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticProperty
import dev.yaaum.presentation.core.analytics.publisher.AnalyticsPublisher
import dev.yaaum.presentation.core.analytics.subscriber.AnalyticsSubscriber

class AnalyticsPublisherImpl : AnalyticsPublisher {

    private var subscribers: List<AnalyticsSubscriber> = arrayListOf()

    override fun subscribe(subscriber: AnalyticsSubscriber) {
        (subscribers as? ArrayList)?.add(subscriber)
    }

    override fun unsubscribe(subscriber: AnalyticsSubscriber) {
        (subscribers as? ArrayList)?.remove(subscriber)
    }

    override fun notify(input: BaseAnalyticModel) {
        subscribers.forEach { subscriber ->
            when (input) {
                is BaseAnalyticProperty -> subscriber.setProperty(input)
                is BaseAnalyticEvent -> subscriber.logEvent(input)
            }
        }
    }
}
