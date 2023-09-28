package dev.yaaum.presentation.core.analytics.core.model.base

/**
 * Represent some kind of analytics properties like age, gender etc
 */
abstract class BaseAnalyticProperty : BaseAnalyticModel {
    abstract val key: String
    abstract val value: Any
}
