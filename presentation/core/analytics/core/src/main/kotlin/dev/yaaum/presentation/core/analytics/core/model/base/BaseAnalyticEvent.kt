package dev.yaaum.presentation.core.analytics.core.model.base

abstract class BaseAnalyticEvent : BaseAnalyticModel {
    abstract val event: String
    abstract val params: Set<Pair<String, Any>>
}