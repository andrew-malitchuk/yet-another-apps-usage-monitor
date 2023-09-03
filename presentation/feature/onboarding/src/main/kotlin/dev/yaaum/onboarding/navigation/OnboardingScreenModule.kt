package dev.yaaum.onboarding.navigation

import cafe.adriel.voyager.core.registry.screenModule
import dev.yaaum.navigation.RouteGraph

val onboardingScreenModule = screenModule {
    register<RouteGraph.OnboardingScreen> {
        OnboardingRoute()
    }
}
