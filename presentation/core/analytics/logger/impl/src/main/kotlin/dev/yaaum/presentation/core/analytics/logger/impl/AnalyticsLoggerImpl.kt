package dev.yaaum.presentation.core.analytics.logger.impl

import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticModel
import dev.yaaum.presentation.core.analytics.logger.AnalyticsLogger
import dev.yaaum.presentation.core.analytics.publisher.AnalyticsPublisher
import dev.yaaum.presentation.core.analytics.subscriber.AnalyticsSubscriber

class AnalyticsLoggerImpl(
    private var publisher: AnalyticsPublisher,
    vararg subscriber: AnalyticsSubscriber,
) : AnalyticsLogger {

    init {
        subscriber.forEach {
            publisher.subscribe(it)
        }
    }

    override fun logEvent(staffToTrack: () -> BaseAnalyticModel) {
        publisher.notify(staffToTrack())
    }
}
