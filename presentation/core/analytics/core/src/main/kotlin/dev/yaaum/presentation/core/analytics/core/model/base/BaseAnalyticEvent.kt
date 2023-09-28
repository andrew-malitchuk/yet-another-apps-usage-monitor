package dev.yaaum.presentation.core.analytics.core.model.base

/**
 * Represent analytic event
 */
abstract class BaseAnalyticEvent : BaseAnalyticModel {
    /**
     * Name of the event
     */
    abstract val event: String

    /**
     * Key-value set
     */
    abstract val params: Set<Pair<String, Any>>
}
