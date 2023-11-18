package dev.yaaum.presentation.core.analytics.subscriber.impl.local

import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticEvent
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticProperty
import dev.yaaum.presentation.core.analytics.subscriber.AnalyticsSubscriber
import logcat.logcat

/**
 * Implementation of [AnalyticsSubscriber]; perform local analytic logging.
 */
class LocalAnalyticsSubscriber : AnalyticsSubscriber {

    override fun logEvent(event: BaseAnalyticEvent) {
        logcat(this::class.simpleName.toString()) { "${event.event} : ${event.params}" }
    }

    override fun setProperty(property: BaseAnalyticProperty) {
        logcat(this::class.simpleName.toString()) { "${property.key} : ${property.value}" }
    }
}
