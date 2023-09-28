package dev.yaaum.presentaion.feature.onboarding.analytics

import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticEvent

class UserPassOnboardingAnalyticsEvent : BaseAnalyticEvent() {
    override val event: String = "onboarding"
    override val params: Set<Pair<String, Any>> = setOf(
        "finished" to true,
    )
}
