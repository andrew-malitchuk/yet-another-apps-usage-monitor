package dev.yaaum.presentation.core.analytics.subscriber

import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticEvent
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticProperty

interface AnalyticsSubscriber {
    fun logEvent(event: BaseAnalyticEvent)
    fun setProperty(property: BaseAnalyticProperty)
}