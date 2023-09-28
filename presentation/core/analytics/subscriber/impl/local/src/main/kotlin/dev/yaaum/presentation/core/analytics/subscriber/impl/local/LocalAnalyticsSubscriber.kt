package dev.yaaum.presentation.core.analytics.subscriber.impl.local

import android.util.Log
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticEvent
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticProperty
import dev.yaaum.presentation.core.analytics.subscriber.AnalyticsSubscriber

class LocalAnalyticsSubscriber : AnalyticsSubscriber {

    override fun logEvent(event: BaseAnalyticEvent) {
        Log.d(this::class.simpleName, "${event.event} : ${event.params}")
    }

    override fun setProperty(property: BaseAnalyticProperty) {
        Log.d(this::class.simpleName, "${property.key} : ${property.value}")
    }

}