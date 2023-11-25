package dev.yaaum.presentation.core.analytics.subscriber.impl.local

import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticEvent
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticProperty
import dev.yaaum.presentation.core.analytics.subscriber.AnalyticsSubscriber
import io.getstream.log.Priority
import io.getstream.log.StreamLog

/**
 * Implementation of [AnalyticsSubscriber]; perform local analytic logging.
 */
class LocalAnalyticsSubscriber : AnalyticsSubscriber {

    override fun logEvent(event: BaseAnalyticEvent) {
        StreamLog.log(
            priority = Priority.INFO,
            tag = this::class.simpleName.toString(),
        ) {
            "${event.event} : ${event.params}"
        }
    }

    override fun setProperty(property: BaseAnalyticProperty) {
        StreamLog.log(
            priority = Priority.INFO,
            tag = this::class.simpleName.toString(),
        ) {
            "${property.key} : ${property.value}"
        }
    }
}
