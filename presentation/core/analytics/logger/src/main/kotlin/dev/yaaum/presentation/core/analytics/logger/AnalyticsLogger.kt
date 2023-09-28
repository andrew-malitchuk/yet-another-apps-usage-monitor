package dev.yaaum.presentation.core.analytics.logger

import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticModel

/**
 * Entry point for analytic logger.
 *
 * Uses set of publishers to log event.
 *
 * [source](https://medium.com/@kastylera/multi-service-analytics-4ca3f9af4a56)
 */
interface AnalyticsLogger {

    /**
     * Log event in DSL way
     *
     * Example:
     * ```Java
     * logEvent {
     *      FoobarAnalyticsEvent(
     *          event = "foobar",
     *          params = setOf(
     *              "foo" to "bar"
     *          )
     *      )
     * }
     * ```
     */
    fun logEvent(staffToTrack: () -> BaseAnalyticModel)
}
