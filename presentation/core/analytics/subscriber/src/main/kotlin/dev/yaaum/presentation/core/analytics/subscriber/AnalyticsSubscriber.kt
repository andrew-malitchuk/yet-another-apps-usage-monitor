package dev.yaaum.presentation.core.analytics.subscriber

import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticEvent
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticProperty

/**
 * Abstract over analytics source, like, firebase, some local implementation etc.
 */
interface AnalyticsSubscriber {
    /**
     * Log analytics event
     *
     * @param event
     */
    fun logEvent(event: BaseAnalyticEvent)

    /**
     * Set some property
     *
     * @param property
     */
    fun setProperty(property: BaseAnalyticProperty)
}
