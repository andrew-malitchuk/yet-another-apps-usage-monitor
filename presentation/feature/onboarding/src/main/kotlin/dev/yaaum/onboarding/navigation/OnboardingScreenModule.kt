package dev.yaaum.onboarding.navigation

import cafe.adriel.voyager.core.registry.screenModule
import dev.yaaum.navigation.RouteGraph
import dev.yaaum.onboarding.navigation.route.OnboardingRoute

/**
 * Module for `presentation:feature:onboarding`
 */
val onboardingScreenModule = screenModule {
    register<RouteGraph.OnboardingScreen> {
        OnboardingRoute()
    }
}
