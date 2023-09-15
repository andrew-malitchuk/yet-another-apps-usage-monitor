package dev.yaaum.onboarding.navigation

import cafe.adriel.voyager.core.registry.screenModule
import dev.yaaum.onboarding.navigation.route.OnboardingRoute
import dev.yaaum.presentation.core.navigation.RouteGraph

/**
 * Module for `presentation:feature:onboarding`
 */
val onboardingScreenModule = screenModule {
    register<RouteGraph.OnboardingScreen> {
        OnboardingRoute()
    }
}
