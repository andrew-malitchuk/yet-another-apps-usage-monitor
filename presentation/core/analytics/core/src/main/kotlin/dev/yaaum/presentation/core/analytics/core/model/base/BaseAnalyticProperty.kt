package dev.yaaum.presentation.core.analytics.core.model.base

abstract class BaseAnalyticProperty : BaseAnalyticModel {
    abstract val key: String
    abstract val value: Any
}