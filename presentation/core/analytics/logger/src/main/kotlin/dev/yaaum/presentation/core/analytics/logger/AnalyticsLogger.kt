package dev.yaaum.presentation.core.analytics.logger

import android.util.Log
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticModel
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticProperty

/**
 * https://medium.com/@kastylera/multi-service-analytics-4ca3f9af4a56
 */
interface AnalyticsLogger {


    fun logEvent(staffToTrack: () -> BaseAnalyticModel)

    /*
    logEvent {
        FooAnalyticEvent(
            key= "foo",
            value = "bar"
        )
    }
     */

//    companion object {
//        fun logEvent(staffToTrack: () -> BaseAnalyticModel) {
////        Log.d("foo", staffToTrack.invoke())
//        }
//    }

}