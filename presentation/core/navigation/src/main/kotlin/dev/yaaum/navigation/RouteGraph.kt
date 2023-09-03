package dev.yaaum.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class RouteGraph : ScreenProvider {
    data object OnboardingScreen : RouteGraph()
    data object MainScreen : RouteGraph()
}
